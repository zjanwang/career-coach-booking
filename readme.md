### 功能 A: "去预约" 列表 (Booking API)

获取cal平台的预约链接。

- **接口地址**: `POST /api/booking-url`
- **请求参数**: `userId` （为了简化, api不需要鉴权，所以userId通过参数传即可）
- **数据返回**: 真实可预约的url

### 功能 B: "我的预约" 列表 (My Bookings API)

用户查询自己的预约记录。

- **接口地址**: `GET /api/bookings`
- **请求参数**: `userId` （为了简化, api不需要鉴权，所以userId通过参数传即可）
- **数据返回**: 预约状态，coach名称，预约时间段

### 功能 C: "去取消预约" (Cancel API)

- **接口地址**: `POST /api/bookings/cancel`
- **数据返回**: 真实可取消预约的url

### 功能 D: 接收预约回调 (Webhook Integration)

当用户完成支付并确认预约后，Cal.com 会发送 `BOOKING_CREATED` 事件。请实现接口处理此逻辑。

- **接口地址**: `POST /api/webhook/cal`