class Solution {

    HashMap<Integer, List<Integer>> courseToPreReqs = new HashMap<>();
    HashSet<Integer> coursesFinished = new HashSet<>();
    HashSet<Integer> coursesTaking = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] courseToPreReq : prerequisites) {
            int course = courseToPreReq[0];
            int preReq = courseToPreReq[1];

            List<Integer> preReqs = courseToPreReqs.getOrDefault(course, new ArrayList<Integer>());
            preReqs.add(preReq);
            courseToPreReqs.put(course, preReqs);
        }

        for(int course=0;course<numCourses;course++) {
            if(!canFinish(course)) {
                return false;
            }
        }

        return true;
    }

    public boolean canFinish(int course) {
        if(coursesFinished.contains(course)) {
            return true;
        }

        if(coursesTaking.contains(course)) {
            return false;
        }


        if (courseToPreReqs.containsKey(course)) {
        coursesTaking.add(course);

        for(int preReq:courseToPreReqs.get(course)) {
            if(canFinish(preReq)) {
                continue;
            } else {
                return false;
            }
        }
        coursesTaking.remove(course);
        }

        coursesFinished.add(course);
        return true;
    }
}
