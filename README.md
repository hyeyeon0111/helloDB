# helloDB

Spring JDBC를 통한 DAO 실습 프로젝트

🔍 **DAO(Data Access Object)**

- **데이터베이스에 액세스** 하기 위한 **CRUD 인터페이스 메소드**(object-oriented API)를 제공하는 **객체**
- Service Layer와 Persistence Layer(DB)의 중간 역할
- JDBC Template, DataSource, JDBC Driver 필요

🔍 **Spring JDBC**
- 모든 low-level details를 처리해준다
- opening the connection, prepare and execute the SQL statement, process exceptions, etc

🔍 **JdbTemplate**
- JDBC framework의 중심 클래스
- 데이터베이스와의 모든 통신 및 예외 처리 관리
- executes SQL queries, performs iteration over ResultSets and extraction of returned parameter values, etc

📄 **Summary**
- **jdbcTemplate** 클래스는 **dataSource**를 의존성 주입받고 **jdbc driver**를 통해서 database와 connection을 만든다
- **DAO 객체**는 **jdbcTemplate을 사용**하여 **CRUD API를 제공**한다

✏️ **Example Description**
- beans.xml: Spring Bean Configuration File
- Offer: Model, 데이터베이스 테이블의 레코드에 해당되는 객체
- **OfferDao**: Offer에 대한 CRUD API 제공
- MainApp: OfferDao를 호출하여 CRUD operation 테스트

✔️ **Run**
  
  <img src="https://user-images.githubusercontent.com/56067179/110274082-5db6ea00-8011-11eb-801f-ada98e711f57.PNG" width="600"/>
