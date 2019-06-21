package rail;

public class Railway {
    private String cityA, cityB;
    private int dist;

    public static final Railway KESZTHELY_BUDAPEST = new Railway("Keszthely", "Budapest", 190);

    public Railway(String cityA, String cityB, int dist) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.dist = dist;
    }

    public static Railway make(String input) {
        String[] parts = input.split(" ");
        if (parts.length == 3 && !parts[0].isEmpty() && !parts[1].isEmpty() && !parts[2].isEmpty()) {
            for (int i=0; i<parts[2].length(); ++i)
                if(!Character.isDigit(parts[2].charAt(i)))
                    return null;
            return new Railway(parts[0], parts[1], Integer.parseInt(parts[2]));
        } else
            return null;
    }

    public String toString() {
        return "Railway(" + cityA + " - " + cityB + " " + dist + ")";
    }

    public int getDistance() {
        return dist;
    }

    public boolean hasEnd(String city) {
        return cityA.equals(city) || cityB.equals(city);
    }

    public String[] getCities() {
        return new String[] {cityA, cityB};
    }

    public String getOtherCity(String city) {
        if (cityA.equals(city))
            return cityB;
        if (cityB.equals(city))
            return cityA;
        return null;
    }
}
