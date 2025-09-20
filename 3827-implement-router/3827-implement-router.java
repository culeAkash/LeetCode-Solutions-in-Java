class Router {
    Map<Integer,List<Integer>> destToTimeListMap;
    Queue<List<Integer>> packets;
    Set<String> packetSet;
    int memoryLimit;
    Set<String> st;
    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        destToTimeListMap = new HashMap<>();
        packetSet = new HashSet<>();
        packets = new LinkedList<>();
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        String inp = source + " " + destination + " " + timestamp;
        if(packetSet.contains(inp))return false;
        

        if(packets.size() == memoryLimit){
            List<Integer> packet = packets.poll();
            int dest = packet.get(1);
            String del = packet.get(0) + " " + packet.get(1) + " " + packet.get(2);
            packetSet.remove(del);
            destToTimeListMap.get(dest).removeFirst();
            if(destToTimeListMap.get(dest).size()==0)destToTimeListMap.remove(dest);
        }
        packetSet.add(inp);
        List<Integer> packet = Arrays.asList(source,destination,timestamp);
        packets.offer(packet);
        destToTimeListMap.computeIfAbsent(destination,(d)-> new ArrayList<>());
        destToTimeListMap.get(destination).add(timestamp);
        return true;
    }
    
    public int[] forwardPacket() {
        if(packets.isEmpty())return new int[0];

        List<Integer> packet = packets.poll();
        packetSet.remove(packet.get(0) + " " + packet.get(1)+ " " + packet.get(2));
        int dest = packet.get(1);
        destToTimeListMap.get(dest).removeFirst();
        if(destToTimeListMap.get(dest).size()==0)destToTimeListMap.remove(dest);

        return new int[]{packet.get(0),packet.get(1),packet.get(2)};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> times = destToTimeListMap.get(destination);

        if(times==null || times.size() ==0)return 0;

        int first = firstOccurence(startTime,times);
        int second = lastOccurence(endTime,times);

        return second - first - 1;
    }

    private int firstOccurence(int time,List<Integer> times){
        int start = 0, end = times.size() - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(times.get(mid) >= time){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return end;
    }

    private int lastOccurence(int time,List<Integer> times){
        int start = 0, end = times.size() - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(times.get(mid) > time){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */