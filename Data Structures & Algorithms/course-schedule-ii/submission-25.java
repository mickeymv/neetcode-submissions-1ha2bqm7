class Solution {

    HashMap<Integer, List<Integer>> courseToPreReqs = new HashMap<>();
    List<Integer> coursesInOrder = new ArrayList<>();
    Set<Integer> coursesTaken = new HashSet<>();
    Set<Integer> coursesTaking = new HashSet<>();


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //if there is a cycle in preReqs, we return empty 

        //we first create a preReqs map. if a course does not have any prereqs, 
        //we add it to the final ouput list, if it does, we dfs into the prereqs list 
        //to find the course and add it 

        for(int[] courseToPreReq : prerequisites) {
            courseToPreReqs.computeIfAbsent(courseToPreReq[0], k->new ArrayList<>()).add(courseToPreReq[1]);
        }

        for(int course=0;course<numCourses;course++) {
            if(!addCourseAndPreReqs(course)) {
                return new int[]{};
            }
        }


        return coursesInOrder.stream().mapToInt(Integer::intValue).toArray();
    }

    public boolean addCourseAndPreReqs(int course) {
        if(coursesTaken.contains(course)) {
            return true; //course already taken
        }
        if(coursesTaking.contains(course)) {
            //cycle detected 
            return false;
        }

        if(courseToPreReqs.containsKey(course)) {
            coursesTaking.add(course);
            for(int preReq : courseToPreReqs.get(course)) {
                if(!addCourseAndPreReqs(preReq)) {
                    return false;
            }
            }
            coursesTaking.remove(course);
        }
        coursesTaken.add(course);
        coursesInOrder.add(course);
        return true;
    }
}
