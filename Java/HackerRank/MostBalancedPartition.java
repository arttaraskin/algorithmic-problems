import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class MostBalancedPartition {

    /*
     * Complete the 'mostBalancedPartition' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY parent
     *  2. INTEGER_ARRAY files_size
     */

    public static int mostBalancedPartition(List<Integer> parent, List<Integer> fileSizes) {
        DirectedGraph graph = new DirectedGraph();
        for (int index = 0 ; index < parent.size() ; index++) {
            graph.addVertex(index, fileSizes.get(index));
            if (index != 0) {
                graph.addEdge(parent.get(index), index);
            }
        }
        return graph.mostBalancedPartition();
    }

    private static class DirectedGraph {
        Map<Integer, Vertex> vertices = new HashMap<>();
        private long diskSize;

        private static class Vertex {
            private final int fileSize;
            private long totalMemoryRequired;
            Set<Vertex> edges = new HashSet<>();

            Vertex(int fileSize) {
                this.fileSize = fileSize;
            }

            void addEdge(Vertex to) {
                this.edges.add(to);
            }
        }

        public void addVertex(int data, int fileSize) {
            vertices.put(data, new Vertex(fileSize));
        }

        public void addEdge(int from, int to) {
            Vertex fromVertex = vertices.get(from);
            fromVertex.addEdge(vertices.get(to));
        }

        int mostBalancedPartition() {
            computeFileDataDistribution();
            return mostBalancedPartition(vertices.get(0));
        }

        private void computeFileDataDistribution() {
            diskSize = computeFileDataDistribution(vertices.get(0));
        }

        private long computeFileDataDistribution(Vertex current) {
            long totalMemoryRequired = current.fileSize;
            for (Vertex child : current.edges) {
                totalMemoryRequired += computeFileDataDistribution(child);
            }
            current.totalMemoryRequired = totalMemoryRequired;
            return current.totalMemoryRequired;
        }

        private int mostBalancedPartition(Vertex current) {
            int result = Integer.MAX_VALUE;
            for (Vertex child : current.edges) {
                result = Math.min(result, mostBalancedPartition(child));
                result = (int) Math.min(result, Math.abs(diskSize - 2 * child.totalMemoryRequired));
            }
            return result;
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int parentCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> parent = IntStream.range(0, parentCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int files_sizeCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> files_size = IntStream.range(0, files_sizeCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.mostBalancedPartition(parent, files_size);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
