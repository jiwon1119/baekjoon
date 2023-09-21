import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static class Node implements Comparable<Node> {
		int to; // 노드의 목적지 정점
		long cost; // 현재 노드까지의 비용(거리) (가중치?)

		Node(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// 비용을 기준으로 노드를 정렬하기 위한 compareTo 메서드
			return Long.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine()); // 섬의 개수

			long[] X = new long[n]; // 각 정점의 x좌표
			long[] Y = new long[n]; // 각 정점의 y좌표
			boolean[] visit = new boolean[n]; // 방문 여부 표시

			// 정점의 x 좌표 입력 처리
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				X[i] = Long.parseLong(st.nextToken());
			}

			// 정점의 y 좌표 입력 처리
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				Y[i] = Long.parseLong(st.nextToken());
			}

			double E = Double.parseDouble(br.readLine()); // 환경 부담 세율

			LinkedList<Node>[] list = new LinkedList[n]; // 가능한 모든 간선의 비용을 저장하는 리스트

			// 모든 정점 쌍에 대해 가능한 간선 정보 계산하여 리스트에 추가
			for (int i = 0; i < n; i++) {
				list[i] = new LinkedList<>();
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;
					// long L은 가중치이자 / 해저터널 길이(L)
					long L = (X[i] - X[j]) * (X[i] - X[j]) + (Y[i] - Y[j]) * (Y[i] - Y[j]);
					list[i].add(new Node(j, L)); // 정점 i에서 정점 j로 가는 간선 정보 추가
				}
			}

			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0)); // 시작 정점 (0번 정점) 추가
			long ans = 0; // MST의 가중치
			int cnt = 0; // 선택된 정점의 개수

			while (!pq.isEmpty()) {
				Node nd = pq.poll(); // 현재 가장 가중치가 작은 노드 선택
				if (visit[nd.to])
					continue; // 이미 방문한 노드면 스킵
				visit[nd.to] = true; // 노드 방문 처리
				ans += nd.cost; // 가중치 누적
				if (++cnt == n)
					break; // 모든 정점을 선택했으면 종료

				for (Node node : list[nd.to]) {
					if (!visit[node.to])
						pq.add(node); // 선택된 노드에서 갈 수 있는 간선 추가
				}
			}

			// 결과 출력 (소수점 이하 버리고 반올림)
			System.out.println("#" + tc + " " + Math.round(ans * E));

		} // tc

	}// main

}