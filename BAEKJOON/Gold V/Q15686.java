import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.List;
import java.util.ArrayList;


class Q15686 {

    static int N;
    static int M;
    static int[][] city;
    static List<Location> houses;
    static List<Location> francises;
    static int minChickDistanceOfCity = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];
        
        houses = new ArrayList<>();
        francises = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                if (city[i][j] == 1) {
                    houses.add(new Location(i, j));
                }
                else if (city[i][j] == 2) {
                    francises.add(new Location(i, j));
                }
            }
        }

        getFranciseLocations(0, new boolean[francises.size()], new ArrayList<Location>());

        System.out.println(minChickDistanceOfCity);
    }

    static void getFranciseLocations(int depth, boolean[] isContains, List<Location> locations) {
        if (depth == M) {
            getChickenDistance(locations);
            
            return;
        }

        for (int i=0; i<francises.size(); i++) {
            if (!isContains[i]) {
                isContains[i] = true;
                locations.add(francises.get(i));
                getFranciseLocations(depth + 1, isContains, locations);

                locations.remove(locations.size()-1);
                isContains[i] = false;
            }
        }
    }

    static void getChickenDistance(List<Location> franciseLocations) {
        int sumDistance = 0;
        for (int i=0; i<houses.size(); i++) {
            int hr = houses.get(i).r;
            int hc = houses.get(i).c;
            
            int minDistance = 100;
            for (int j=0; j<franciseLocations.size(); j++) {
                Location franciseLocation = franciseLocations.get(j);
                int fr = franciseLocation.r;
                int fc = franciseLocation.c;
                minDistance = Math.min(Math.abs(fr - hr) + Math.abs(fc - hc), minDistance);
            }

            sumDistance += minDistance;
        }

        minChickDistanceOfCity = Math.min(sumDistance, minChickDistanceOfCity);
    }

    static class Location {
        int r;
        int c;

        public Location(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}