package com.rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;

// https://github.com/devreena03/hackerrank-restapi-java/blob/main/src/com/reena/match/FootballMatch.java
// https://github.com/JNYH/HackerRank_certification_REST_API_intermediate/blob/master/README.md
public class Main {
    private static final String competitionURL = "https://jsonmock.hackerrank.com/api/football_competitions";
    private static final String matchURL = "https://jsonmock.hackerrank.com/api/football_matches";

    public static void main(String[] args) throws IOException, ParseException {
        System.out.println(countDraws(2011));
        System.out.println(getTotalGoals("Inter", "UEFA Champions League", 2011));
        System.out.println(getWinnerTotalGoals("UEFA Champions League", 2011));
    }

    public static int countDraws(int year) throws IOException, ParseException {
        int maxGoal = 10;
        int sum = 0;
        for (int i = 1; i <= maxGoal; i++) {
            String url = matchURL + String.format("?year=%s&page=%s&team1goals=%s&team2goals=%s", year, 1, i, i);
            JsonObject json = getData2(url);
            int total = json.get("total").getAsInt();
            sum += total;
        }
        return sum;
    }

    /*
     * Complete the 'getWinnerTotalGoals' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING competition
     *  2. INTEGER year
     */
    public static int getWinnerTotalGoals(String competition, int year) throws UnsupportedEncodingException {
        String url = String.format(competitionURL + "?year=%d&name=%s", year, URLEncoder.encode(competition, "UTF-8"));
        String teamName = getWinnerTeamName(url);
        System.out.println("Winner team: " + teamName);
        return getTotalGoals(URLEncoder.encode(teamName, "UTF-8"), URLEncoder.encode(competition, "UTF-8"), year);
    }

    private static String getWinnerTeamName(String url) {

        JsonObject response = getData(url + "&page=1");
        JsonElement e = response.getAsJsonArray("data").get(0);

        return e.getAsJsonObject().get("winner").getAsString();
    }

    public static int getTotalGoals(String team, String competition, int year) {
        return totalGoalByTeam(year, team, "team1", competition) +
            totalGoalByTeam(year, team, "team2", competition);
    }

    private static int totalGoalByTeam(int year, String team, String teamN, String competition) {
        String endpoint = String.format(matchURL + "?year=%s&%s=%s&competition=%s&page=%s", year, teamN, team, competition, 1);
        JsonObject json = getData(endpoint);
        if (json == null) {
            return 0;
        }
        int totalPages = json.get("total_pages").getAsInt();

        int totalGoals = 0;
        for (int i = 1; i <= totalPages; i++) {
            endpoint = String.format(matchURL + "?year=%s&%s=%s&competition=%s&page=%s", year, teamN, team, competition, i);
            json = getData(endpoint);
            JsonArray data = json.getAsJsonArray("data");
            for (JsonElement e : data) {
                int goals = e.getAsJsonObject().get(teamN + "goals").getAsInt();
                totalGoals += goals;
            }
        }
        return totalGoals;
    }

    private static JsonObject getData(String endpoint) {
        HttpURLConnection con = null;
        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(endpoint);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String response;
                while ((response = br.readLine()) != null) {
                    sb.append(response);
                }
            }
        } catch (IOException e) {
            return null;
        } finally {
            con.disconnect();
        }

        return new Gson().fromJson(sb.toString(), JsonObject.class);
    }

    private static JsonObject getData2(String endpoint) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(endpoint);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                String result = EntityUtils.toString(response.getEntity());
                return new Gson().fromJson(result, JsonObject.class);
            }
        }
    }
}