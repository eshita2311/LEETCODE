class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int len = reservedSeats.length;
        for(int i = 0; i < len; i++) {
            int key = reservedSeats[i][0];
            int val = reservedSeats[i][1];

            if(val >= 2 && val <= 9) {
                if(!map.containsKey(key)) map.put(key, new ArrayList<>());
                map.get(key).add(val);
            }

        }

        int total = (n - map.size()) * 2;
        int temp[] = new int[10];
        for(List<Integer> ls : map.values()) {
            Arrays.fill(temp, 1);
           

            for(int x : ls) {
    
                if(x >= 2 && x <= 5) temp[x] = 0;
                if(x >= 4 && x <= 7) temp[x] = 0;
                if(x >= 6 && x <= 9) temp[x] = 0;
                
            }

            for(int i = 2; i < 10; i +=2) {
                boolean flag = true;
                if(i + 3 > 9) continue;
                for(int j = i + 3; j >= i; j--) {
                    if(temp[j] == 0) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    i += 4;
                    total += 1;
                }
            }
        }

        return total;
    }
}