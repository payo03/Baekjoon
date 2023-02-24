import java.util.*;
import java.util.Map.Entry;

public class BestAlbum {
    public static void main(String[] args) {

        Solution sol = new Solution();

        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };

        System.out.println();
        System.out.println(sol.solution(genres, plays));
        System.out.println();
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answers = new ArrayList<>();

        // 장르별로 Descending 처리 > genreSortList
        HashMap<String, Integer> genreMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {

            int value = 0;
            if (genreMap.get(genres[i]) != null) {
                value = genreMap.get(genres[i]);
            }

            genreMap.put(genres[i], value + plays[i]);
        }

        List<Entry<String, Integer>> genreSortList = new ArrayList<>(genreMap.entrySet());
        genreSortList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        // 장르별 Descending 처리 끝

        // 장르별 Descending의 playList 정렬 > playsMapList
        List<Map<Integer, Integer>> playsMapList = new ArrayList<>();
        for (Entry<String, Integer> genreEntry : genreSortList) {

            // play 순번 매기기
            Map<Integer, Integer> playMap = new HashMap<>();
            for (int i = 0; i < plays.length; i++) {
                if (genreEntry.getKey().equals(genres[i])) {
                    playMap.put(i, plays[i]);
                }
            }

            List<Entry<Integer, Integer>> playEntryList = new ArrayList<>(playMap.entrySet());
            playEntryList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

            Map<Integer, Integer> playSortMap = new LinkedHashMap<>();
            for (Entry<Integer, Integer> playEntry : playEntryList) {
                playSortMap.put(playEntry.getKey(), playEntry.getValue());
            }
            playsMapList.add(playSortMap);
        }
        // playList 처리 끝

        for (int i = 0; i < playsMapList.size(); i++) {

            int count = 0;
            for (int key : playsMapList.get(i).keySet()) {

                answers.add(key);
                if (++count / 2 != 0) break;
            }
        }
        
        return answers.stream().mapToInt(integer -> integer).toArray();
    }
}