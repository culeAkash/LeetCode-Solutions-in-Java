class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        Collections.sort(events,(e1,e2)->{
            if(!e1.get(1).equals(e2.get(1))){
                return Integer.compare(Integer.parseInt(e1.get(1)),Integer.parseInt(e2.get(1)));
            }else{
                if(e1.get(0).equals("OFFLINE") && e2.get(0).equals("MESSAGE"))return -1;
                else
                    return 1;
            }
        });

        // for(List<String> event : events){
        //     System.out.println(event.get(0) + " " + event.get(1) + " " + event.get(2));
        // }



        Map<Integer,int[]> mpp = new HashMap<>();

        for(int num = 0;num <numberOfUsers;num++){
            mpp.put(num,new int[]{0,-1});
        }

        for(List<String> event : events){
            String eventTag = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            String[] ids = event.get(2).split(" ");

            if(eventTag.equals("OFFLINE")){
                mpp.get(Integer.parseInt(ids[0]))[1] = timestamp + 60;
            }else{
                if(ids[0].equals("ALL")){
                    for(int key = 0;key <numberOfUsers;key++){
                        mpp.get(key)[0]++;
                    }
                }else if(ids[0].equals("HERE")){
                    for(int key = 0;key <numberOfUsers;key++){
                        if(mpp.get(key)[1] <= timestamp){
                            mpp.get(key)[0]++;
                        }
                    }
                }else{
                    for(String id : ids){
                        int key = Integer.parseInt(id.substring(2));
                        mpp.get(key)[0]++;
                    }
                }
            }
        }

        int[] ans = new int[numberOfUsers];

        for(int key = 0;key <numberOfUsers;key++){
            ans[key] = mpp.get(key)[0];
        }

        return ans;
    }
}