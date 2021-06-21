package com.ssafy.ws;

import java.util.*;

//백준문제
public class 토마토_김지현 {
	static class Tomato {
		int x, y, state;

		Tomato(int x, int y, int state) {
			this.x = x;
			this.y = y;
			this.state = state;
		}
	}

	private static Scanner sc = new Scanner(System.in);
	private static int[][] map;
	private static int[] dx = { 0, 0, -1, 1 };
	private static int[] dy = { -1, 1, 0, 0 };
	private static int N, M;
	private static int[][] visited;
	private static int day = 0;

	public static void main(String[] args) {
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new int[N][M];
		setMap();

		bfs(0, 0, map[0][0]);

		day = isResult();

		System.out.println(day);
	}

	static void setMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
	}

	static void bfs(int x, int y, int state) {
		Tomato tomato = new Tomato(x, y, state);
		Queue<Tomato> queue = new LinkedList<Tomato>();
		queue.offer(tomato);
		while (!queue.isEmpty()) {
			Tomato getTomato = queue.poll();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {

				}
			}

			visited[getTomato.x][getTomato.y] = 1;
			int checkX, checkY;
			for (int i = 0; i < 4; i++) {
				checkX = x + dx[i];
				checkY = y + dy[i];
				if (isOut(checkX, checkY))
					continue;
				else {
					map[checkX][checkY] = 1;
				}

			}
		}
	}

	static boolean isOut(int x, int y) {
		if (x < 0 || y < 0 || x > N || y > N)
			return true;
		else
			return false;
	}

	static int isResult() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1) {
					return -1;
				}
			}
		}
		return day;
	}
}
