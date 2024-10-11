import java.util.Arrays;
class Solution{
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int photoSize = photo.length;
        int[] answer = new int[photoSize];
        for(int i = 0; i < photoSize; i++) answer[i] = findCost(name, yearning, photo[i]);

        return answer;
    }
    private int findCost(String[] name, int[] yearning, String[] photos){
        int sum = 0;
        for (String photoName : photos) {
            int nameIndex = findNameIndex(name, photoName);
            if(nameIndex == -1) continue;
            sum += yearning[nameIndex];
        }
        return sum;
    }
    private int findNameIndex(String[] name, String photoName){
        for(int i = 0; i < name.length; i++)
            if(name[i].equals(photoName)) return i;
        return -1;
    }
}