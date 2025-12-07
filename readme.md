# 项目文件详解

## 主应用类

### [CareerCoachApplication.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\CareerCoachApplication.java)
- Spring Boot应用程序入口点
- 使用`@SpringBootApplication`注解启用自动配置
- 包含[main](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\Main.java#L5-L15)方法启动整个应用

## 控制层文件

### [BookingController.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\controller\BookingController.java)
- 处理预约相关REST API请求
- 提供三个核心接口：
    - `POST /api/booking-url`: 生成预约链接
    - `GET /api/bookings`: 查询用户预约记录
    - `POST /api/bookings/cancel`: 生成取消预约链接
- 通过`@Autowired`注入[BookingService](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\service\BookingService.java#L9-L38)处理业务逻辑

### [WebhookController.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\controller\WebhookController.java)
- 处理来自Cal.com的Webhook通知
- 提供`POST /api/webhook/cal`接口接收事件通知
- 通过`@Autowired`注入[WebhookService](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\service\WebhookService.java#L10-L55)处理事件

## 服务层文件

### [BookingService.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\service\BookingService.java)
- 实现预约核心业务逻辑
- 负责生成预约/取消链接
- 管理预约数据查询和保存操作
- 通过`@Autowired`注入[BookingRepository](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\repository\BookingRepository.java#L10-L22)进行数据访问

### [WebhookService.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\service\WebhookService.java)
- 处理Webhook事件的核心服务
- 解析[BOOKING_CREATED](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\enums\BookingStatus.java#L5-L5)事件并更新预约状态
- 通过`@Autowired`注入[BookingRepository](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\repository\BookingRepository.java#L10-L22)和[BookingService](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\service\BookingService.java#L9-L38)进行数据操作

## 数据访问层文件

### [BookingRepository.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\repository\BookingRepository.java)
- MyBatis Mapper接口定义预约数据操作
- 提供保存预约、按用户ID查询、按Cal预订ID查询等功能
- 使用MyBatis注解(`@Insert`, `@Select`)定义SQL语句

### [CoachRepository.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\repository\CoachRepository.java)
- MyBatis Mapper接口定义导师数据操作
- 提供按邮箱查询导师功能
- 使用`@Select`注解定义查询SQL

## 实体类文件

### [Booking.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\entity\Booking.java)
- 预约信息实体类
- 包含预约的所有核心属性：用户ID、导师信息、时间、状态等
- 使用[BookingStatus](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\enums\BookingStatus.java#L3-L9)枚举维护预约状态

### [Coach.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\entity\Coach.java)
- 导师信息实体类
- 包含导师的基本信息：姓名、邮箱、Cal集成ID

## 数据传输对象

### [BookingRequest.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\dto\BookingRequest.java)
- 预约请求数据传输对象
- 封装用户ID参数用于API调用

### [BookingResponse.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\dto\BookingResponse.java)
- 预约响应数据传输对象
- 封装返回给前端的预约信息

### [WebhookEvent.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\dto\WebhookEvent.java)
- Webhook事件数据传输对象
- 包含事件类型和载荷数据
- 内部类[EventPayload](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\dto\WebhookEvent.java#L24-L53)封装具体的事件内容

## 枚举类

### [BookingStatus.java](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\enums\BookingStatus.java)
- 预约状态枚举定义
- 包含五种状态：[PENDING](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\enums\BookingStatus.java#L4-L4), [BOOKING_CREATED](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\enums\BookingStatus.java#L5-L5), [BOOKING_CANCELLED](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\enums\BookingStatus.java#L6-L6), [MEETING_ENDED](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\enums\BookingStatus.java#L7-L7), [NO_SHOW](file://C:\Users\user\IdeaProjects\career-coach-booking\src\main\java\org\example\careercoach\enums\BookingStatus.java#L8-L8)
- 严格按照业务需求定义状态流转