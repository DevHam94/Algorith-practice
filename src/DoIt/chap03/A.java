package DoIt.chap03;
// 자연 정렬을 하려면 다음과 같은 패턴으로 클래스를 정의

class A implements Comparable<A> {

    // 필드, 메서드 등

    public int compareTo(A c) {
        // this가 c보다 크면 양의 값 반환
        // this가 c보다 작으면 음의 값 반환
        // this가 c와 같으면 0 반환
        return 0;
    }

    public boolean equals(Object c) {
        // this가 c와 같으면 true 반환
        // this가 c와 같지 않으면 false 반환
        return false;
    }
}
