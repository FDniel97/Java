package rail;

import java.util.LinkedList;
import java.io.IOException;

public class RailMap {
    private Railway[] railways;
    private String country;

    public RailMap(String country, String[] lines) {
        railways = new Railway[lines.length];
        int cnt = 0;
        this.country = country;
        for (int i=0; i<lines.length; ++i) {
            Railway r = Railway.make(lines[i]);
            if (r != null)
                railways[cnt++] = r;
        }
    }

    public String toString() {
        return "RailMap(" + country + "," + railways + ")";
    }

    public String[] getNeighbours(String city) {
        String[] neighbours = new String[railways.length];
        int cnt = 0;
        for (int i=0; i<railways.length; ++i) {
            if (railways[i] == null) break;
            if (railways[i].hasEnd(city)) {
                String neighbour = railways[i].getOtherCity(city);
                neighbours[cnt++] = neighbour;
            }
        }
        return neighbours;
    }

    public String[] getCities() {
        String[] cities = new String[railways.length*2];
        int cnt = 0;
        for (int i=0; i<railways.length; ++i) {
            if(railways[i] == null) break;
            String[] ends = railways[i].getCities();
            for (int j=0; j<2; ++j) {
                boolean contains = false;
                for(int k=0; k<cnt && !contains; ++k)
                    contains = cities[k].equals(ends[j]);
                if (!contains)
                    cities[cnt++] = ends[j];
            }
        }
        return cities;
    }

    public String capitalCity() {
        String[] cities = getCities();
        int maxNeighbours = 0;
        String capital = "";
        for (int i=0; i<cities.length; ++i) {
            if(cities[i] == null)
                break;
            String[] neighbours = getNeighbours(cities[i]);
            int cnt;
            for(cnt = 0; neighbours[cnt] != null; ++cnt) {}
            if (cnt > maxNeighbours) {
                capital = cities[i];
                maxNeighbours = cnt;
            }
        }
        return capital;
    }
}
