class TaskManager {

    PriorityQueue<Task> pq;
    Map<Integer,Task> taskToTaskMap;

    public TaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>();
        taskToTaskMap = new HashMap<>();

        for(List<Integer> task : tasks){
            int userId = task.get(0);
            int taskId = task.get(1);
            int priority = task.get(2);

            Task newtask = new Task(userId,taskId,priority);

            pq.offer(newtask);
            taskToTaskMap.put(taskId,newtask);
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId,taskId,priority);
        pq.offer(task);
        taskToTaskMap.put(taskId,task);
    }
    
    public void edit(int taskId, int newPriority) {
        int userId = taskToTaskMap.get(taskId).userId;
        Task task = new Task(userId,taskId,newPriority);
        pq.offer(task);
        taskToTaskMap.put(taskId,task);
    }
    
    public void rmv(int taskId) {
        taskToTaskMap.remove(taskId);
    }
    
    public int execTop() {
        while(!pq.isEmpty()){
            Task top = pq.poll();

            Integer userId = top.userId;
            Integer taskId = top.taskId;
            Integer priority = top.priority;

            Task current = taskToTaskMap.get(taskId);

            if(current!=null && current.priority.equals(top.priority) && current.userId.equals(userId)){
                taskToTaskMap.remove(taskId);
                return current.userId;
            }
        }
        return -1;
        // while(!pq.isEmpty()){
        //     Task top = pq.poll();

        // int userId = top.userId;
        // int taskId = top.taskId;
        // int priority = top.priority;
        // System.out.println(userId + " " + taskId + " " + priority);
        // }
        

        // if(pq.isEmpty()) return -1;
        // Task top = pq.poll();

        // int userId = top.userId;
        // int taskId = top.taskId;
        // int priority = top.priority;
        
        // while(!taskToTaskMap.containsKey(taskId) || taskToTaskMap.get(taskId).priority != priority || userId != taskToTaskMap.get(taskId).userId){
        //     System.out.println(userId + " " + taskId + " " + priority);

        //     if(pq.isEmpty())return -1;

        //     top = pq.poll();

        //     userId = top.userId;
        //     taskId = top.taskId;
        //     priority = top.priority;
        // }
        // taskToTaskMap.remove(taskId);
        // return userId;
    }
}


class Task implements Comparable<Task>{
    Integer userId;
    Integer taskId;
    Integer priority;

    public Task(Integer userId,Integer taskId,Integer priority){
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }

    public int compareTo(Task other){
        if(this.priority.equals(other.priority))
            return other.taskId - this.taskId;
        
        return other.priority - this.priority;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */