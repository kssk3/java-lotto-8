# java-lotto-precourse  

# 로또 미션
## 기능 요구 사항 

간단한 로또 발매기를 구현한다.  
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않게 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등 : 6개 번호 일치 / 2,000,000,000원
  - 2등 : 5개 번호 일치 + 보너스 번호 일치 / 30,000,000원 
  - 3등 : 5개 번호 일치 / 1,500,000원
  - 4등 : 4개 번호 일치 / 50,000원
  - 5등 : 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하려면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고, 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그부분부터 입력을 다시 받는다. 
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException`등과 같은 명확한 유형으로 처리한다.
  
### 입출력 요구 사항
**입력**  
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며, 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
```
14000
```  
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
```
1,2,3,4,5,6
```
  
**출력**  
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.  
```
8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]
```  

- 당첨 내역을 출력한다.
```
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```
  
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51,5%, 1,000,000,000.0%)  
```
총 수익률은 62.5%입니다.
```
  
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```
  
**실행 결과 예시**  
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```  

---  

## 프로그래밍 요구 사항 3
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
  - switch/case도 허용하지 않는다.
  - 힌트 : if 조건절에서 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
  
### 라이브러리
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
  
**사용 예시**  
```
Randoms.pickUniqueNumbersInRange(1, 45, 6);
```  
  
### Lotto 클래스 
- 제공된 `Lotto` 클래스를 사용하여 구현한다.
- `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- `numbers`의 접근 제어자인 `private`은 변경할 수 없다.
- `Lotto`의 패키지를 변경할 수 있다.
```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
```  

--- 

## 핵심 구현 사항 및 설계 의도

### 1. 예외 발생 시 재입력 처리 - retryOnException 메서드

예외 발생 시 해당 입력 단계만 재시도하도록 구현한 재사용 가능한 예외 처리 메서드

```java
private <T> T retryOnException(Supplier<T> supplier) {
    while (true) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
```

**핵심 개념:**
- 제네릭과 함수형 인터페이스(Supplier)를 활용하여 예외 처리와 재시도 로직을 한 곳에 캡슐화
- 예외 발생 시 전체 입력을 처음부터 다시 받는 것이 아니라, 예외가 발생한 단계만 재입력

**주요 장점:**
1. **재사용성**: `initializeGame`, `getLottoRound`, `getWinningNumbers`, `getBonusNumber` 4곳에서 동일한 예외 처리 로직 재사용
2. **단일 책임 원칙**: 각 입력 메서드는 입력과 검증만 담당, 재시도 로직은 `retryOnException`에서 분리
3. **타입 안정성**: 제네릭 `<T>`로 다양한 반환 타입(LottoGame, LottoRound, List<Integer>, int) 지원

**구현 포인트:**
- `Supplier<T>` 사용으로 지연 실행 구현: `get()` 호출 시점에 실제 입력 로직 실행
- 예를 들어, 구입 금액 입력 → 당첨 번호 입력 중 당첨 번호에서 예외 발생 시, 구입 금액부터 다시 받지 않고 당첨 번호만 재입력

**사용 예시:**
```java
private LottoRound getLottoRound() {
    return retryOnException(() -> {
        this.outputView.printRequestPurchaseAmount();
        String input = inputView.readLine();
        return this.lottoGameService.createRoundFromAmout(input);
    });
}
```

---

### 2. 2등과 3등 구분하기 - 정적 팩토리 메서드

5개 일치 시 보너스 번호 일치 여부에 따라 2등/3등을 구분하는 로직

```java
public static LotteryPrize from(int matchCount, boolean bonusMatch) {
    // 5개 맞춤 + 보너스까지 일치하면 2등
    if (matchCount == Constants.BONUS_ELIGIBILITY_COUNT && bonusMatch) {
        return SECOND;
    }
    // 5개 맞춤 + 보너스 일치하지 않을 경우 3등
    if (matchCount == Constants.BONUS_ELIGIBILITY_COUNT && !bonusMatch) {
        return THIRD;
    }

    return Arrays.stream(values())
            .filter(value -> value.matchCount == matchCount)
            .findFirst()
            .orElse(NONE);
}
```

**문제 상황:**
- 5개 일치 시 보너스 번호 일치 여부에 따라 2등(30,000,000원) / 3등(1,500,000원)으로 상금이 크게 차이남
- 나머지 등수(1등, 4등, 5등)는 일치 개수만으로 판별 가능

**해결 방법:**
- 정적 팩토리 메서드 패턴(`from`)을 사용하여 `matchCount`와 `bonusMatch`를 기반으로 적절한 Enum 반환
- Early Return으로 특수 케이스(5개 일치)를 먼저 처리하여 `else` 사용 제거

**구현 특징:**
1. **조건 우선 처리**: 5개 일치 케이스를 먼저 처리하여 보너스 번호 여부에 따라 2등/3등 분기
2. **Stream 활용**: 나머지 케이스(1등, 4등, 5등)는 Enum values를 순회하여 `matchCount`가 일치하는 등수 반환
3. **안전한 처리**: 어떤 등수에도 해당하지 않으면 `NONE` 반환 (0개, 1개, 2개 일치)

---

### 3. 당첨 통계 처리 - LottoResults 클래스

모든 당첨 결과를 관리하고 통계를 계산하는 일급 컬렉션

```java
public List<LotteryPrize> getPrizesInOrder() {
    return Arrays.stream(LotteryPrize.values())
            .filter(prize -> prize != LotteryPrize.NONE)
            .sorted(Comparator.comparing(LotteryPrize::getPrize))
            .toList();
}

public int getCountByPrize(LotteryPrize otherPrize) {
    return (int) lotteryPrizes.stream()
            .filter(prize -> prize.equals(otherPrize))
            .count();
}

public int getTotalPrizeAmount() {
    return lotteryPrizes.stream()
            .mapToInt(LotteryPrize::getPrize)
            .sum();
}
```

**1. getPrizesInOrder() 메서드**
- **역할**: NONE(미당첨)을 제외한 모든 등수를 상금 기준 오름차순으로 정렬
- **용도**: 통계 출력 시 5등(5,000원) → 4등 → 3등 → 2등 → 1등(2,000,000,000원) 순서로 출력
- **구현**: Enum의 모든 값을 가져와 NONE 필터링 후 상금(`getPrize()`) 기준 정렬

**2. getCountByPrize(LotteryPrize otherPrize) 메서드**
- **역할**: 특정 등수의 당첨 횟수를 반환
- **용도**: "5개 일치 (1,500,000원) - 2개" 같은 통계 출력
- **예시**: 2등이 2번 당첨되었으면 `getCountByPrize(SECOND)` 호출 시 `2` 반환

**3. getTotalPrizeAmount() 메서드**
- **역할**: 모든 당첨 상금의 총합 계산
- **용도**: 수익률 계산 (총 상금 / 구매 금액 × 100)
- **구현**: 각 당첨 결과의 상금을 `mapToInt`로 추출하여 합산

---

### 4. 당첨 번호 매칭 로직 - matchTicketsWithWinning

구매한 모든 로또와 당첨 번호를 비교하여 등수를 판별하는 핵심 메서드

```java
private static List<LotteryPrize> matchTicketsWithWinning(LottoGame lottoGame, WinningLotto winningLotto) {
    List<LotteryPrize> matchLottoResults = new ArrayList<>();

    Lottos lottos = lottoGame.getLottos();
    for (Lotto lotto : lottos.getAll()) {
        int count = (int) lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();

        boolean bonusMatch = lotto.getNumbers().stream()
                .anyMatch(number -> number == winningLotto.getBonusNumber());

        matchLottoResults.add(LotteryPrize.from(count, bonusMatch));
    }
    return matchLottoResults;
}
```

**처리 과정:**
1. 각 로또의 번호를 당첨 번호와 비교하여 일치 개수(`count`) 계산
2. 구매한 로또에 보너스 번호 포함 여부(`bonusMatch`) 확인
3. `LotteryPrize.from(count, bonusMatch)`으로 등수 결정 후 결과 리스트에 추가

**구현 세부사항:**
- **일치 개수 계산**: Stream의 `filter`를 사용하여 당첨 번호 목록에 포함된 번호만 필터링 후 `count()`
- **보너스 매칭**: `anyMatch`로 보너스 번호 포함 여부만 확인 (실제 2등 판별은 `LotteryPrize.from`에서 처리)
- **중요**: `bonusMatch`가 `true`여도 일치 개수가 5개가 아니면 2등이 아님 (등수 판별 책임은 `LotteryPrize.from`에 있음)

**설계 포인트:**
- 매칭 로직과 등수 판별 로직을 분리하여 각 메서드의 책임을 명확히 함
- `static` 메서드로 구현하여 외부 상태에 의존하지 않는 순수 함수로 작성

---

### 5. 당첨 번호 유효성 검증 - WinningLotto

당첨 번호와 보너스 번호의 중복을 검증하는 도메인 객체

```java
public WinningLotto(List<Integer> numbers, Integer bonus) {
    validate(numbers);
    ensureBonusNumberUnique(numbers, bonus);
    this.numbers = new LinkedList<>(numbers);
    this.bonusNumber = bonus;
}

private void ensureBonusNumberUnique(List<Integer> numbers, Integer bonusNumber) {
    if (numbers.contains(bonusNumber)) {
        throw new IllegalArgumentException(
                LottoGameException.PREFIX + " 당첨 번호와 보너스 번호가 중복될 수 없습니다. "
                + bonusNumber + " 다른 번호를 입력해주세요.");
    }
}
```

**검증 내용:**
1. **당첨 번호 검증**: null 체크, 빈 리스트 체크, 6개 숫자 확인
2. **보너스 번호 중복 검증**: 당첨 번호 6개에 보너스 번호가 포함되지 않았는지 확인

**설계 의도:**
- 생성자에서 검증하여 유효하지 않은 `WinningLotto` 객체가 생성되지 않도록 방어
- 비즈니스 규칙(당첨 번호와 보너스 번호는 중복될 수 없음)을 도메인 객체 내부에 캡슐화

---

## 기능 구현 목록
- [x] 로또 구입 금액 입력 받는다.
  - [x] 구입 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리 발생
  - [x] 입력값이 숫자가 아닐 경우 예외 처리 발생
  - [x] 구입한 티켓 수량 출력 후 로또 번호 출력
- [x] 당첨 로또 번호를 입력 받는다.
  - [x] 당첨 번호가 6개가 아닐 경우 예외 처리 발생
  - [x] 당첨 번호가 중복일 경우 예외 처리 발생
  - [x] 당첨 번호와 보너스 번호가 중복될 경우 예외 처리 발생
  - [x] 당첨 번호가 1부터 45 사이의 값이 아닐 경우 예외 처리 발생
- [x] 당첨
  - [x] 당첨된 등수와 수량 출력
  - [x] 수익률 출력
- [x] 예외 처리가 된 경우 예외 메시지를 출력하고 그 부분부터 다시 입력 받기

---

## 실행 결과 
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[1, 6, 13, 32, 37, 39]
[2, 17, 24, 25, 32, 38]
[1, 4, 6, 14, 20, 43]
[14, 17, 24, 33, 38, 39]
[2, 3, 7, 23, 39, 45]
[7, 21, 23, 30, 35, 44]
[1, 2, 10, 20, 23, 40]
[29, 30, 37, 41, 42, 44]

당첨 번호를 입력해 주세요.
1,2,6,13,35,45

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```