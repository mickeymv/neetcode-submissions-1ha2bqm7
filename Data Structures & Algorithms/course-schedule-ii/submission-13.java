class Solution {

    Map<Integer, HashSet<Integer>> courseToPreReqs = new HashMap<>();
    Set<Integer> coursesTaken = new HashSet<>();
    Set<Integer> coursesVisiting = new HashSet<>();
    List<Integer> coursesInOrder = new LinkedList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        //create map of all courses to their prereqs
        for (int[] courseToPreReq : prerequisites) {
            int course = courseToPreReq[0];
            int preReq = courseToPreReq[1];

            HashSet<Integer> preReqs = courseToPreReqs.getOrDefault(course, new HashSet<>());
            preReqs.add(preReq);
            courseToPreReqs.put(course, preReqs);
        }

        for(int course=0;course<numCourses;course++){
            boolean canTakeCourse = takeCourse(course);

                    if (!canTakeCourse) {
                        return new int[]{};
                    }
        }

        return coursesInOrder.stream()
    .mapToInt(Integer::intValue)
    .toArray();

    }

    public boolean takeCourse(int course) {
        if (coursesVisiting.contains(course)) {
            //cycle exists 
            return false;
        }

        if (coursesTaken.contains(course)) {
            //course is already taken
            return true;
        }

        //try to take course 

        if(courseToPreReqs.get(course)!=null) {
                Set<Integer> preReqs = courseToPreReqs.get(course);
                coursesVisiting.add(course);
                
                for(int preReq : preReqs) {
                    boolean canTakePreReq = takeCourse(preReq);

                    if (!canTakePreReq) {
                        return false;
                    }
                }
                coursesVisiting.remove(course);
        }

            //course has no more prereqs, take it!
                coursesTaken.add(course);
                coursesInOrder.add(course);
                return true;

    }
}
