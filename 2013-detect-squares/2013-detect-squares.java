class DetectSquares {
    Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];

        map.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> ys = map.get(x);

        ys.put(y, ys.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int ans = 0;

        if (!map.containsKey(x)) return 0;

        for (int x2 : map.keySet()) {
            if (x2 == x) continue;

            int side = Math.abs(x2 - x);

            int countBase = map.get(x2).getOrDefault(y, 0);
            if (countBase == 0) continue;

            int up = map.get(x2).getOrDefault(y + side, 0);
            int up2 = map.get(x).getOrDefault(y + side, 0);

            int down = map.get(x2).getOrDefault(y - side, 0);
            int down2 = map.get(x).getOrDefault(y - side, 0);

            ans += countBase * up * up2;
            ans += countBase * down * down2;
        }

        return ans;
    }
}