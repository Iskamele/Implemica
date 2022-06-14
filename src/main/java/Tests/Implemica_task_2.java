package Tests;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.min;
import static java.util.Arrays.fill;

public class Implemica_task_2 {
    static int INF = 200000; // infinity
    static int[][] graph; // adjacency matrix
    static int vNum; // number of vertices
    static int s; // number of tests

    // quantity receiving method with limit parameter
    public static int getCount(String getCountQuestion, int limit) {
        System.out.println(getCountQuestion);
        int value = new Scanner(System.in).nextInt();

        while (value > limit) {
            System.out.println("Limit is exceeded! Enter value >= " + limit + ": ");
            value = new Scanner(System.in).nextInt();
        }

        // TODO more perfect validation is needed for the final version of the program

        return value;
    }

    // сity name receiving method
    public static String getCityName(String question) {
        System.out.println(question);
        String userEnter = new Scanner(System.in).nextLine();

        while (!userEnter.matches("([a-z]+)") || userEnter.length() > 10) {
            System.out.println("The title must contain a-z and be shorter than 10 characters in length: ");
            userEnter = new Scanner(System.in).nextLine();
        }

        return userEnter;
    }

    // сity pair acceptance method for path computation
    public static String getCityPair() {
        System.out.println("From where to where: ");

        //TODO validation

        return new Scanner(System.in).nextLine();
    }


    public static int[] getCityConnection() {
        System.out.println("City index and cost: ");
        String userEnter = new Scanner(System.in).nextLine();

        //if (userEnter.matches("\\d")) {
        while (!userEnter.matches("(^[1-9])(\\d+)?(\\s)([1-9])(\\d+)?")) {
            System.out.println("Enter a pair of values greater than 0, for example \"2 3\": ");
            userEnter = new Scanner(System.in).nextLine();
        }

        // splitting an array into pieces
        String[] words = userEnter.split(" ");

        //TODO validation

        return new int[]{Integer.parseInt(words[0]), Integer.parseInt(words[1])};
    }

    // getting input
    public static void main(String[] args) {

        int testLimit = 10;
        int citiesLimit = 10000;
        int taskLimit = 100;

        // tests
        s = getCount("Number of tests: ", testLimit);
        for (int test = 0; test < s; test++) {

            // getting the number of cities and initializing the adjacency matrix
            for (int t = 0; t < s; t++) {
                vNum = getCount("Number of cities: ", citiesLimit);
                HashMap<String, Integer> citiesMap = new HashMap<>();
                graph = new int[vNum][vNum];

                // filling adjacency matrix with INF value
                for (int i = 0; i < vNum; i++) {
                    fill(graph[i], INF);
                }

                // adding city names to hashmap
                for (int indexCity = 0; indexCity < vNum; indexCity++) {
                    citiesMap.put(getCityName("City name: "), indexCity);
                    int neighbor = getCount("His number of neighbors: ", vNum -1);

                    // filling the adjacency matrix with links and costs
                    for (int neighborIterator = 0; neighborIterator < neighbor; neighborIterator++) {
                        int[] link = getCityConnection(); // example input: 1 10
                        graph[indexCity][link[0] - 1] = link[1]; // -1 for not getting ArrayIndexOutOfBoundsException
                    }
                }

                // getting a task and splitting it into parts
                int taskCount = getCount("Number of cities searched: ", taskLimit);
                String[] split = new String[taskCount];
                for (int i = 0; i < taskCount; i++) {
                    split[i] = getCityPair();
                }

                // start solution
                for (int i = 0; i < taskCount; i++) {
                    String[] words = split[i].split(" ");
                    solution(citiesMap.get(words[0]), citiesMap.get(words[1]));
                }
                System.out.println();
            }
        }
    }

    static void solution(int start, int finish) {
        // annotation array
        boolean[] used = new boolean[vNum];

        // distance array. dist[v] = minimum distance(start, v)
        int[] dist = new int[vNum];

        // filling an array with an INF value
        fill(dist, INF);

        // for the initial vertex we put 0
        dist[start] = 0;

        while (true) {
            int v = -1;

            for (int nv = 0; nv < vNum; nv++) { // iterate over the vertices
                if (!used[nv] && dist[nv] < INF && (v == -1 || dist[v] > dist[nv])) { // select the closest unallocated vertex
                    v = nv;
                }
            }
            if (v == -1) {
                break;
            } // nearest vertex not found

            used[v] = true; // mark it

            for (int nv = 0; nv < vNum; nv++) {
                if (!used[nv] && graph[v][nv] < INF) {// for all unlabeled contiguous
                    dist[nv] = min(dist[nv], dist[v] + graph[v][nv]); // improve feedback
                }
            }
        }
        System.out.println(dist[finish]);
    }
}