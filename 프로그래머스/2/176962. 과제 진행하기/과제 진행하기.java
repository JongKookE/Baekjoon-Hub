import java.util.*;


class Solution {
        public String[] solution(String[][] plans) {
            int size = plans.length;
            Plan[] planArray = new Plan[size];
            for (int i = 0; i < size; i++) {
                planArray[i] = new Plan(plans[i][0], plans[i][1], plans[i][2]);
            }
            Arrays.sort(planArray, Comparator.comparingInt(p -> p.time));

            Deque<Plan> queue = new ArrayDeque<>(Arrays.asList(planArray)); // 대기중 (FIFO)
            Deque<Plan> stack = new ArrayDeque<>();                        // 중단됨 (LIFO)
            List<String> answer = new ArrayList<>();

            Plan current = queue.pollFirst();
            int currentTime = current.time;

            while (current != null) {
                if (queue.isEmpty()) {
                    // 더 이상 새로 시작할 과제가 없으니 현재 과제를 끝까지 진행
                    currentTime += current.cost;
                    answer.add(current.subject);
                    current = stack.pollLast(); // 스택에 남은 과제 재개, 없으면 null
                } else {
                    Plan next = queue.peekFirst();
                    int gap = next.time - currentTime;

                    if (current.cost <= gap) {
                        // 다음 과제 시작 전에 현재 과제가 끝남
                        currentTime += current.cost;
                        answer.add(current.subject);

                        if (!stack.isEmpty()) {
                            current = stack.pollLast(); // 중단됐던 과제 재개
                            // currentTime은 그대로 (이미 흘러간 시간 유지)
                        } else {
                            current = queue.pollFirst(); // 다음 과제로
                            currentTime = current.time;  // 만약 텀이 있으면 시간 점프
                        }
                    } else {
                        // 다음 과제 시작 시각이 되면 현재 과제는 중단됨
                        current.cost -= gap;       // 남은 작업량 갱신
                        stack.addLast(current);    // 스택에 쌓기
                        current = queue.pollFirst();
                        currentTime = current.time;
                    }
                }
            }

            return answer.toArray(new String[0]);
        }
        static class Plan {
            String subject;
            int time, cost;

            public Plan(String subject, String time, String cost) {
                this.subject = subject;
                this.time = this.toTime(time);
                this.cost = Integer.parseInt(cost);
            }

            private int toTime(String time) {
                String[] split = time.split(":");
                return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            }
        }
}