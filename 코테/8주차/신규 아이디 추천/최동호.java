public class Solution {
    public String solution(String new_id) {
        // 1단계: 대문자를 소문자로 변환
        String id = new_id.toLowerCase();

        // 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 문자 제거
        id = id.replaceAll("[^a-z0-9-_.]", "");

        // 3단계: 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        id = id.replaceAll("[.]+", ".");

        // 4단계: 마침표(.)가 처음이나 끝에 위치한다면 제거
        id = id.replaceAll("^[.]|[.]$", "");

        // 5단계: 빈 문자열이라면 "a"를 대입
        if (id.isEmpty()) {
            id = "a";
        }

        // 6단계: 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 제거
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            id = id.replaceAll("[.]$", "");
        }

        // 7단계: 길이가 2자 이하라면 마지막 문자를 반복해서 끝에 붙임
        while (id.length() <= 2) {
            id += id.charAt(id.length() - 1);
        }

        return id;
    }
}