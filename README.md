
# 구성 정보
- Java 21 
- Spring Boot 3.3.2
- Gradle 8.x
- MySQL, MSSQL, H2 Database 모두 가능하도록 작성
  - build.gradle, application.yml 에서 설정 변경 가능
    - 처음 확인시, h2로 확인해보세요 (주석처리 해둠)
    - h2는 메모리 DB로, 서버 재시작시 데이터가 초기화됩니다.
- MyBatis, JPA, QueryDsl 예제 모두 작성
- 테스트 작성
  - 도메인 테스트 (단위 테스트)
  - 서비스 테스트 (h2를 이용한 통합 테스트)
- [스프링부트_기초_가이드](./docs/스프링부트_기초_가이드.pdf)

# Layered Architecture
- 도메인을 갖는 레이어드 아키텍처는 다음 그림과 같습니다.
![layered](./docs/layered.png)

## Presentation Layer
- presentation 패키지
- 사용자와의 상호작용을 담당
- 사용자의 요청을 받아 처리하고, 응답을 사용자에게 전달
- 사용자의 요청을 처리하기 위해 Application Layer에게 요청을 전달

## Service Layer
- domain 패키지 안에 둠
- UseCase를 처리하기 위해 Domain Layer에게 전달
- 데이터의 상태를 변경하기 위해 Infrastructure Layer에게 요청을 전달

## Domain Layer
- domain 패키지
- 비즈니스 로직을 담당
- **데이터의 비즈니스적 유효성을 검증**하고, 데이터의 상태를 변경

## Data Transfer Object
- domain 패키지 (필요한 각 레이어마다 위치시키기도..)
- 데이터 전송을 담당
- 데이터를 Presentation Layer와 Domain Layer, Infrastructure Layer 간에 전달
- 생성자에서 데이터를 초기화하고 불변하게 관리하는 것(record)을 지향
- 생성자에서 **데이터 타입과 값에 대한 검증**을 수행

## Infrastructure Layer
- infrastructure 패키지
- 데이터의 상태를 변경
- 데이터베이스에 데이터를 저장하거나, 데이터베이스로부터 데이터를 조회

![layered_architecture](./docs/layered_detail.png)

# API 명세
- Swagger를 이용하여 API 명세를 작성
  - localhost:8080/swagger-ui/index.html
