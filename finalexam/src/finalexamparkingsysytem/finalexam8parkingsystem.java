package finalexamparkingsysytem;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * @see  Scanner 문
 * @see Map, HashMap 키와 값을 저장하는 자료구조
 * @see Random 랜덤값을 생성하는 클래스
 *  *컬렉션 프레임워크, 랜덤값 생성클래스입니다.
 *
 * @author cho hyun soo(hyunsoo821cho@gmail.com)
 *  @version 24.2.3
 *  @since 24.10.8
 *
 * @created 2024-12-25
 * @lastModified 2024-12-25
 *
 * @changelog
 * <ul>
 *    <li>2024-12-25: 컬렉션 프레임워크를 활용한 주차  현황판(cho hyun soo)</li>
 * </ul>
 */
public class finalexam8parkingsystem {

    private static final int TOTAL_SPACES = 200;
    private int occupiedSpaces;
    private int availableSpaces;
    /**
     * TOTAL_SPACES: 주차 공간의 총 자리의 개수로 200으로 설정
     * occupiedSpaces: 현재 주차 자리의 수를 나타내는 변수입니다.
     * availableSpaces: 비어있는 주차 공간 자리 수를 나타내는 변수
     *
     * @author cho hyun soo(hyunsoo821cho@gmail.com)
     *  @version 24.2.3
     *  @since 24.10.8
     *
     * @created 2024-12-25
     * @lastModified 2024-12-25
     *
     * @changelog
     * <ul>
     *    <li>2024-12-25: 컬렉션 프레임워크를 활용한 주차  현황판(cho hyun soo)</li>
     * </ul>
     */

    public static void main(String[] args) {
        finalexam8parkingsystem app = new finalexam8parkingsystem();
        app.simulateParking();
        app.displayParkingStatus();
    }
    /**
     * simulateParking() 주차 공간의 상태를 시뮬레이션.
     * displayParkingStatus() 주차 공간의 상태를 출력
     *
     * @author cho hyun soo(hyunsoo821cho@gmail.com)
     *  @version 24.2.3
     *  @since 24.10.8
     *
     * @created 2024-12-25
     * @lastModified 2024-12-25
     *
     * @changelog
     * <ul>
     *    <li>2024-12-25: 컬렉션 프레임워크를 활용한 주차  현황판(cho hyun soo)</li>
     * </ul>
     */

    public finalexam8parkingsystem() {
        simulateParking();
    }

    private void simulateParking() {
        Random random = new Random();
        this.occupiedSpaces = random.nextInt(TOTAL_SPACES + 1);
        this.availableSpaces = TOTAL_SPACES - occupiedSpaces;
    }
    /**
     * Random random = new Random();은 랜덤 숫자를 생성하는 Random 객체를 생성
     * occupiedSpaces = random.nextInt(TOTAL_SPACES + 1);은 0부터 TOTAL_SPACES 200까지의 랜덤한 숫자를 생성하여 현재 주차된 자리를 설정
     * availableSpaces = TOTAL_SPACES - occupiedSpaces;는 차지된 공간을 제외한 남은 공간을 계산하여 비어있는 주차 공간 수를 설정
     *
     * @author cho hyun soo(hyunsoo821cho@gmail.com)
     *  @version 24.2.3
     *  @since 24.10.8
     *
     * @created 2024-12-25
     * @lastModified 2024-12-25
     *
     * @changelog
     * <ul>
     *    <li>2024-12-25: 컬렉션 프레임워크를 활용한 주차  현황판(cho hyun soo)</li>
     * </ul>
     */
    private void displayParkingStatus() {
        Map<Integer, String> parkingSpaces = new HashMap<>();
        for (int i = 1; i <= TOTAL_SPACES; i++) {
            parkingSpaces.put(i, i <= occupiedSpaces ? "Occupied" : "Available");
        }

        System.out.println("Total Spaces: " + TOTAL_SPACES);
        System.out.println("Occupied Spaces: " + occupiedSpaces);
        System.out.println("Available Spaces: " + availableSpaces);
        System.out.println("Parking Space Status:");
        for (Map.Entry<Integer, String> entry : parkingSpaces.entrySet()) {
            System.out.println("Space " + entry.getKey() + ": " + entry.getValue());
        }
        /**
         * Map<Integer, String> parkingSpaces = new HashMap<>();: 주차 공간 번호와 상태(차지된 상태 또는 비어 있는 상태)를 저장하는 Map을 생성
         *
         * @author cho hyun soo(hyunsoo821cho@gmail.com)
         *  @version 24.2.3
         *  @since 24.10.8
         *
         * @created 2024-12-25
         * @lastModified 2024-12-25
         *
         * @changelog
         * <ul>
         *    <li>2024-12-25: 컬렉션 프레임워크를 활용한 주차  현황판(cho hyun soo)</li>
         * </ul>
         */
    }
}