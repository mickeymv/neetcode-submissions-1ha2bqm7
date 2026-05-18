class Solution {
    Map<Integer, List<Integer>> courseToPrerequisites = new HashMap<>();
    Set<Integer> finishableCourses = new HashSet<>();
    Set<Integer> visitedCourses = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build course to prereqs map
        for(int[] prerequisitePair : prerequisites) {
            int course = prerequisitePair[0];
            int prerequisite = prerequisitePair[1];
            courseToPrerequisites.putIfAbsent(course, new ArrayList<>());
            courseToPrerequisites.get(course).add(prerequisite);
        }    

        for (int courseNumber = 0 ; courseNumber < numCourses && !finishableCourses.contains(courseNumber); courseNumber++) {
            if (!canFinish(courseNumber)) {
                return false;
            } else {
                finishableCourses.add(courseNumber);
            }
        }

        return true;
    }

    public boolean canFinish(int courseNumber) {
        //check if course has any prereqs 
        if (courseToPrerequisites.containsKey(courseNumber)) {
            List<Integer> prerequisites = courseToPrerequisites.get(courseNumber);
            if (visitedCourses.contains(courseNumber)) {
                return false; //cycle detected
            }
            visitedCourses.add(courseNumber);
            for (int prerequisite : prerequisites) {
                if (!canFinish(prerequisite)) {
                    return false;
                } else {
                    finishableCourses.add(courseNumber);
                }
            }
            visitedCourses.remove(courseNumber);
            return true;
        } else {
            return true; // no prereqs, can be finished
        }
    }
}
