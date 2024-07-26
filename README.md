
# Layered Architecture

- 도메인을 갖는 레이어드 아키텍처는 다음 그림과 같다.
![layered](./docs/layered.png)

- 각 레이어는 다음과 같은 특징을 가진다.
## Presentation Layer
### (Controller)
- 사용자와의 상호작용을 담당한다.
- 사용자의 요청을 받아 처리하고, 응답을 사용자에게 전달한다.
- 사용자의 요청을 처리하기 위해 Application Layer에게 요청을 전달한다.
## Domain Layer
### Application Layer (Service)
- 사용자의 요청을 처리한다.
- 사용자의 요청을 처리하기 위해 Domain Layer에게 요청을 전달한다.
### Domain Layer (Entity)
- 비즈니스 로직을 담당한다.
- **데이터의 비즈니스적 유효성을 검증**하고, 데이터의 상태를 변경한다.
- 데이터의 상태를 변경하기 위해 Infrastructure Layer에게 요청을 전달한다.
### Data Transfer Object (Dto)
- 데이터 전송을 담당한다.
- 데이터를 Presentation Layer와 Domain Layer, Infrastructure Layer 간에 전달한다.
- 생성자에서 데이터를 초기화하고 불변하게 관리하는 것(record)을 지향한다.
- 생성자에서 **데이터 타입과 값에 대한 검증**을 수행한다.
## Infrastructure Layer
### (Repository)
- 데이터의 상태를 변경한다.
- 데이터베이스에 데이터를 저장하거나, 데이터베이스로부터 데이터를 조회한다.
- 데이터베이스로부터 데이터를 조회하기 위해 Domain Layer에게 요청을 전달한다.

![layered_architecture](./docs/layered_detail.png)
