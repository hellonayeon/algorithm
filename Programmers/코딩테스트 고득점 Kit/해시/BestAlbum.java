import java.util.ArrayList;
import java.util.HashMap;

class BestAlbum {
    public  int[] solution(String[] genres, int[] plays) {
        // 장르 리스트
        ArrayList<String> genre_list = new ArrayList<>();
        // key = 장르, val = 고유번호 배열 리스트
        HashMap<String, ArrayList< Integer>> num_map = new HashMap<>();
        // key = 장르, val = 재생 횟수 총 합
        HashMap<String, Integer> play_map = new HashMap<>();
        // 고유 번호 배열
        int[] serial_num = new int[plays.length];

        
        // 장르 리스트, num_map 초기화
        for(String genre : genres) {
            if(!num_map.containsKey(genre)) {
                genre_list.add(genre);
                num_map.put(genre, new ArrayList<>());
            }
        }

        // play_map 초기화 (장르별 총 재생 횟수)
        for(int i = 0; i < plays.length; i++)
            play_map.put(genres[i], play_map.getOrDefault(genres[i], 0) + plays[i]);

        // 고유 번호 배열 초기화
        for(int i = 0; i < serial_num.length; i++)
            serial_num[i] = i;

            
        // 총 재생 횟수가 많은 순으로, 장르 배열 정렬
        int[] genre_total_play = new int[genre_list.size()];
        int idx = 0;
        for(String genre : genre_list)
            genre_total_play[idx++] = play_map.get(genre);
        
        int[] genre_num = new int[genre_list.size()];
        for(int i = 0; i < genre_num.length; i++)
            genre_num[i] = i;

        sort(genre_total_play, genre_num);

        // 총 재생 횟수가 많은 순으로, 장르 저장
        String[] best_genres = new String[play_map.size()];
        for(int i  = 0; i < genre_num.length; i++) {
            best_genres[i] = genre_list.get(genre_num[i]);
        }

        // 재생 횟수가 가장 많은 순으로, 고유번호 정렬
        sort(plays, serial_num);

        // 재생 횟수가 많은 순으로, 장르별 고유번호 저장
        for(int i  = 0; i < serial_num.length; i++) {
            num_map.get(genres[serial_num[i]]).add(serial_num[i]);
        }
        
        // 재생 횟수가 많은 장르 순으로, 앨범 배열 초기화
        ArrayList<Integer> best_album = new ArrayList<>();
        for(int i = 0; i < best_genres.length; i++) {
            ArrayList<Integer> list = num_map.get(best_genres[i]);
            if(list.size() == 1) {
                best_album.add(list.get(0));
            }   
            else {
                best_album.add(list.get(0));
                best_album.add(list.get(1));
            }
        }
        
        // list to int arr
        int[] ans = new int[best_album.size()];
        for(int i = 0; i < ans.length; i++)
            ans[i] = best_album.get(i);

        return ans;
    }

    public void sort(int[] arr, int[] idx) {
        for(int i = 1; i < arr.length; i++) {
			int element1 = arr[i];
            int element2 = idx[i];
			
			int j = i - 1;
			
			while(j >= 0 && element1 > arr[j]) {
				arr[j + 1] = arr[j];
                idx[j + 1] = idx[j];
				j--;
			}

			arr[j + 1] = element1;
            idx[j + 1] = element2;
        }
    }

}