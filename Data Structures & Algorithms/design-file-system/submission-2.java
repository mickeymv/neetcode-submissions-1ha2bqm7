class FileSystem {

    Map<String, Integer> pathToValue;

    public FileSystem() {
        pathToValue = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if (path == null || path.isEmpty() || path.indexOf("/")==-1 || path.length()<2) {
            return false;
        }
        if (path.indexOf("/") == path.lastIndexOf("/")) {
            //only one directory
            if (pathToValue.containsKey(path)) {
                return false;//directory already exists
            } else {
                pathToValue.put(path, value);
                return true;
            }
        } else {
            //parent directory exists
            int lastIndexOfSlash = path.lastIndexOf("/");
            String parentDirectory = path.substring(0, lastIndexOfSlash);

            if (!pathToValue.containsKey(parentDirectory)) {
                return false;//parent directory does not exist
            } 

            //check final child directory 
            if (pathToValue.containsKey(path)) {
                return false;//directory already exists
            } else {
                pathToValue.put(path, value);
                return true;
            }

        }

    }
    
    public int get(String path) {
        if (pathToValue.containsKey(path)) {
                return pathToValue.get(path);
            } else {
                return -1;
            }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
