class Solution {
    class Room {
        int id;
        int freeAt;
        Room(int id, int freeAt) {
            this.id = id;
            this.freeAt = freeAt;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<Room> busy = new PriorityQueue<>((a, b) -> a.freeAt == b.freeAt ? a.id - b.id : a.freeAt - b.freeAt);
        PriorityQueue<Room> free = new PriorityQueue<>((a, b) -> a.id - b.id);
        
        for (int i = 0; i < n; i++) 
            free.add(new Room(i, 0));

        Arrays.sort(meetings, (x, y) -> Integer.compare(x[0], y[0]));
        int[] usageCount = new int[n];
        
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int duration = meeting[1] - meeting[0];

            while (!busy.isEmpty() && busy.peek().freeAt <= start) 
                free.offer(busy.poll());
            
            Room room = !free.isEmpty() ? free.poll() : busy.poll();
            usageCount[room.id]++;

            int actualStart = Math.max(room.freeAt, start);
            room.freeAt = actualStart + duration;

            busy.add(room);
        }

        int max = -1;
        int res = -1;
        for (int i = 0; i < n; i++) {
            if (max < usageCount[i]) {
                max = usageCount[i];
                res = i;
            }
        }
        return res;
    }
}