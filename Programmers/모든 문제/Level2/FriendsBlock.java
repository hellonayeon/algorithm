// https://velog.io/@hyeon930/프로그래머스-프렌즈4블록-Java

class FriendsBlock {
	public int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] map = new char[m][n];
		
		for(int i = 0 ; i < m ; ++i) {
			map[i] = board[i].toCharArray();
		}
		
		while(true) {
			int cnt = checkBlock(m, n, map);
			if(cnt == 0) break;
			answer += cnt;
			
            // 블록 카운트가 끝나면, 블록이 아래로 떨어지는 처리
			dropBlock(m, n, map);
		}
		
		return answer;
	}
	
	private void dropBlock(int m, int n, char[][] map) {
		for(int c = 0 ; c < n ; ++c) {
			for(int r = m - 1 ; r >= 0 ; --r) {
				// 제거된 블록이라면
                if(map[r][c] == '.') {
				
                    // 제거된 블록 상단을 체크해서
                    // 블록이 있을 경우, 아래로 떨어뜨린다.
                    for(int nr = r - 1 ; nr >= 0 ; --nr) {
						if(map[nr][c] != '.') {
							map[r][c] = map[nr][c];
							map[nr][c] = '.';
							break;
						}
					}
				
                }
			
            }
		}
	}

	private int checkBlock(int m, int n, char[][] map) {
		int cnt = 0;
		boolean[][] isChecked = new boolean[m][n];
		
        // (0, 0) ~ (n-1, m-1) 까지의 좌표 기준
		for(int i = 0 ; i < m - 1 ; ++i) {
			for(int j = 0 ; j < n - 1 ; ++j) {
				if(map[i][j] == '.') continue;
				checkFour(map, isChecked, i, j);
			}
		}
		
        // 모든 블록들에 대해서 check가 끝나면
        // 1. 제거할 수 있는 블록의 개수 카운트
        // 2. 확인한 블록 표시
		for(int i = 0 ; i < m ; ++i) {
			for(int j = 0 ; j < n ; ++j) {
				if(isChecked[i][j]) {
					cnt++;
					map[i][j] = '.';
				}
			}
		}
		
		return cnt;
	}

	private void checkFour(char[][] map, boolean[][] isChecked, int i, int j) {
		char block = map[i][j];
		
        // 인접한 4개의 블록을 검사 (기준 블록, 오른쪽 블록, 하단 블록, 대각선 블록)
		for(int r = i ; r < i + 2 ; ++r) {
			for(int c = j ; c < j + 2 ; ++c) {
                // 하나라도 동일한 블록이 없다면 함수 종료
				if(map[r][c] != block) return;
			}
		}
		
        // 인접한 4개의 블록이 모두 동일하다면, 체크
		for(int r = i ; r < i + 2 ; ++r) {
			for(int c = j ; c < j + 2 ; ++c) {
				isChecked[r][c] = true;
			}
		}
	}
}
