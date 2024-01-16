import java.util.Scanner;

public class EulerianPathAndCircuit {

    private int V; // Jumlah vertices
    private int[][] adjMatrix; // Matriks adjacensi

    // Constructor
    public EulerianPathAndCircuit(int v) {
        V = v;
        adjMatrix = new int[v][v];
    }

    // Menambahkan edge
    public void addEdge(int start, int end, boolean isConnected) {
        if (isConnected) {
            adjMatrix[start - 1][end - 1] = 1;
            adjMatrix[end - 1][start - 1] = 1;
        }
    }

    // Menghitung derajat vertex
    private int getDegree(int vertex) {
        int degree = 0;
        for (int i = 0; i < V; i++) {
            degree += adjMatrix[vertex][i];
        }
        return degree;
    }

    // Mengecek Eulerian
    public void checkEulerian() {
        int odd = 0;
        for (int i = 0; i < V; i++) {
            if ((getDegree(i) % 2) != 0) {
                odd++;
            }
        }

        if (odd == 0) {
            System.out.println("Graph memiliki Eulerian Circuit");
        } else if (odd == 2) {
            System.out.println("Graph memiliki Eulerian Path");
        } else {
            System.out.println("Graph tidak memiliki Eulerian Path maupun Eulerian Circuit");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukan jumlah node didalam sebuah graf: ");
        int numNodes = scanner.nextInt();
        EulerianPathAndCircuit graph = new EulerianPathAndCircuit(numNodes);

        System.out.println("Tentukan node mana saja yang terhubung: ");
        for (int i = 1; i <= numNodes; i++) {
            for (int j = i + 1; j <= numNodes; j++) {
                System.out.println("Node " + i + " – Node " + j + " : True/False");
                boolean isConnected = scanner.nextBoolean();
                graph.addEdge(i, j, isConnected);
            }
        }

        graph.checkEulerian();
    }
    }


