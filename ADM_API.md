## API 接口文档

### 1、分类接口
#### 1.1、查询分类接口列表

##### 方法
    /cateory/list
    
##### 参数
    无

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List<CategoryResp>|分类结果集|

    分类结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|cateId|Long|分类Id|
|cateName|string|分类名称|
|level|int|分类层级|
|type|string|归属| SHOP-超市/CANTEEN-食堂|
|childList|List<CategoryResp>|子分类列表||

#### 1.2、添加分类接口

##### 方法
    /cateory/save
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|cateName|string|分类名称|
|level|int|层级|
|pid|long|父Id|

##### 返回值
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|Long|分类结果集|分类Id|


#### 1.3、编辑分类接口

##### 方法
    /cateory/edit
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|cateId|long|分类Id|
|cateName|string|分类名称|

##### 返回值
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|分类结果集||

#### 1.4、分类状态变更接口

##### 方法
    /cateory/status/{cateId}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|cateId|long|分类Id|

##### 返回值
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|分类结果集||

#### 1.5、分类详情接口

##### 方法
    /cateory/{cateId}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|cateId|long|分类Id|

##### 返回值
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|category|分类结果集||

### 2、商品库接口
#### 2.1、查询商品列表接口

##### 方法
    /goods/list
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|goodsCode|string|商品编号|
|start|string|开始日期|
|end|string|结束日期|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List<Goods>|商品结果集|

    商品结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|goodsId|Long|商品Id|
|goodsName|string|商品名称|
|imgUrl|string|图片路径|
|price|float|商品单价|
|addTime|date|添加时间|
|leftNum|int|库存数量|
|lastDate|date|上次进货时间|


#### 2.2、添加商品接口

##### 方法
    /goods/save
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|goodsCode|string|商品编号|
|goodsName|string|商品名称|
|price|float|商品单价|
|imgUrl|string|图片URL|
|specDesc|string|规格说明|
|leftNum|int|库存|
|updown|int|上下架状态|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|Long|商品Id|

#### 2.3、编辑商品接口

##### 方法
    /goods/edit/{id}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|id|long|商品id|
|goodsCode|string|商品编号|
|goodsName|string|商品名称|
|price|float|商品单价|
|imgUrl|string|图片URL|
|specDesc|string|规格说明|
|leftNum|int|库存|
|updown|int|上下架状态|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|结果集|


#### 2.4、查看商品详情接口

##### 方法
    /goods/{id}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|id|long|商品id|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|Goods|商品结果集|

    商品结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|goodsId|Long|商品Id|
|goodsName|string|商品名称|
|imgUrl|string|图片路径|
|price|float|商品单价|
|addTime|date|添加时间|
|leftNum|int|库存数量|
|lastDate|date|上次进货时间|


#### 2.5、商品状态变更接口

##### 方法
    /goods/status/{id}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|id|long|商品id|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|结果集|

#### 2.6、商品盘点导出模板
##### 方法
    /export/tmpl/check
    
##### 参数
    无

##### 返回值
    模板文件

#### 2.7、商品盘点导入
##### 方法
    /import/goods/check
    
##### 参数
    商品盘点文件

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|结果集|


#### 2.8、商品导入模板下载

##### 方法
    /export/tmpl/goods
    
##### 参数
    无

##### 返回值
    模板文件


#### 2.9、商品导入
##### 方法
    /import/goods
    
##### 参数
    商品导入文件

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|结果集|


#### 2.10、商品上下架
##### 方法
    /goods/updown
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|id|Long|商品Id|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|结果集|


### 3、菜品模板接口
#### 3.1、菜品模板查询列表接口

##### 方法
    /goods/tmpl/list
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|tmplName|string|模板名称|
|start|string|开始日期|
|end|string|结束日期|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List<GoodsTmpl>|商品模板结果集|

    商品结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|tmplId|Long|模板Id|
|tmplName|string|模板名称|
|state|string|状态|
|addTime|date|添加时间|

#### 3.2、添加模板接口

##### 方法
    /goods/tmpl/save
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|tmplName|string|模板名称|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|long|模板id|

#### 3.3、查看模板接口

##### 方法
    /goods/tmpl/{id}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|id|long|模板id|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|GoodsTmpl|商品模板结果集|

    商品结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|tmplId|Long|模板Id|
|tmplName|string|模板名称|
|state|string|状态|
|addTime|date|添加时间|

#### 3.4、编辑模板接口

##### 方法
    /goods/tmpl/edit/{id}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|id|long|模板id|
|tmplName|string|模板名称|
|state|string|状态|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|long|模板id|

### 4、菜单管理接口

#### 4.1、查看菜单明细列表

##### 方法
    /goods/nume/{date}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|date|string|日期|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List|商品结果集|

    商品结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|goodsId|Long|商品Id|
|goodsName|string|商品名称|
|tags|string|商品标签|

#### 4.2、保存菜单

##### 方法
    /goods/save/{date}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|date|string|日期|
|breakfast|List|早餐列表|
|lunch|list|中餐列表|
|dinner|list|晚餐列表|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|结果集|


### 5、套餐管理接口

#### 5.1、查询套餐列表接口

##### 方法
    /goods/meal/list
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|mealName|string|套餐名称|
|start|string|开始日期|
|end|string|结束日期|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List|套餐结果集|

    商品结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|id|Long|套餐Id|
|mealName|string|套餐名称|
|state|string|状态|
|addTime|date|添加时间|

#### 5.2、添加套餐

##### 方法
    /goods/meal/save
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|mealName|string|套餐名称|
|mealPrice|float|套餐单价|
|details|list|套餐明细|

    套餐明细
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|cateId|long|类型Id|
|num|int|数量| 

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|long|套餐id|

#### 5.3、查看套餐详情

##### 方法
    /goods/meal/{id}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|id|long|套餐id|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List|套餐明细列表|

    套餐明细
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|cateId|long|类型Id|
|cateName|string|类型名称|
|num|int|数量| 

#### 5.4、编辑套餐

##### 方法
    /goods/meal/edit/{id}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|id|long|套餐id|
|mealName|string|套餐名称|
|mealPrice|float|套餐单价|
|details|list|套餐明细|

    套餐明细
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|cateId|long|类型Id|
|num|int|数量| 

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|long|套餐id|

#### 5.5、套餐上下架

##### 方法
    /goods/meal/updown/{id}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|id|long|套餐id|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|结果|


### 6、订单管理接口
#### 6.1、查询订单列表

##### 方法
    /order/list
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|orderNo|string|订单号|
|start|string|开始日期|
|end|string|结束日期|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List|订单结果集|

    订单结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|id|Long|订单Id|
|orderNo|string|订单编号|
|userCode|string|员工工号|
|userName|string|员工名称|
|orderType|string|订单类型|
|orderAmount|float|订单金额|
|state|string|状态|
|addTime|date|添加时间|

#### 6.2、查看订单详情

##### 方法
    /order/{orderNo}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|orderNo|string|订单号|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|Order|订单结果集|

    订单结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|id|Long|订单Id|
|orderNo|string|订单编号|
|userCode|string|员工工号|
|userName|string|员工名称|
|orderType|string|订单类型|
|orderAmount|float|订单金额|
|state|string|状态|
|addTime|date|添加时间|
|goodsList|List|商品列表|

    商品详情
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|goodsId|Long|商品Id|
|goodsName|string|商品名称|
|imgUrl|string|图片路径|
|price|float|商品单价|
|addTime|date|添加时间|
|leftNum|int|库存数量|
|lastDate|date|上次进货时间|

#### 6.3、导出订单列表

##### 方法
    /export/order
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|goodCode|string|商品编号|
|start|string|开始日期|
|end|string|结束日期|

##### 返回值
    订单文件


### 7、用户管理接口
#### 7.1、查询员工列表接口

##### 方法
    /user/list
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|userCode|string|员工工号 / 员工名称|
|start|string|开始日期|
|end|string|结束日期|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List|套餐结果集|

    员工结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|id|Long|员工Id|
|userCode|string|员工工号|
|userName|string|员工姓名|
|cardCode|string|绑定卡号|
|mobile|string|手机号|
|amount|float|余额|
|state|string|状态|
|addTime|date|添加时间|

#### 7.2、添加员工

##### 方法
    /user/save
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|userCode|string|员工工号|
|userName|string|员工姓名|
|cardCode|string|绑定卡号|
|mobile|string|手机号|
|payPwd|string|支付密码|
|amount|float|冲值金额|
|desc|string|备注|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|id|结果集|


#### 7.3、查看员工

##### 方法
    /user/{id}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|userCode|string|员工工号|
|userName|string|员工姓名|
|cardCode|string|绑定卡号|
|mobile|string|手机号|
|payPwd|string|支付密码|
|amount|float|冲值金额|
|desc|string|备注|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|user|员工结果集|

    员工信息
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|userId|long|员工id|
|userCode|string|员工工号|
|userName|string|员工姓名|
|cardCode|string|绑定卡号|
|mobile|string|手机号|
|payPwd|string|支付密码|
|amount|float|冲值金额|
|desc|string|备注|

#### 7.4、编辑员工

##### 方法
    /user/edit/{id}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|userId|long|员工Id|
|userCode|string|员工工号|
|userName|string|员工姓名|
|cardCode|string|绑定卡号|
|mobile|string|手机号|
|payPwd|string|支付密码|
|amount|float|冲值金额|
|desc|string|备注|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|id|结果集|

#### 7.5、员工绑定卡

##### 方法
    /user/card/{id}/{cardCode}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|userId|long|员工Id|
|cardCode|string|绑定卡号|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|id|结果集|

#### 7.6、导出导入员工模板

##### 方法
    /export/user/tmpl
    
##### 参数
    无

##### 返回值
    员工导入模板文件

#### 7.7、导入员工

##### 方法
    /import/user
    
##### 参数
    员工导入模板文件

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|结果集|

#### 7.8、导出员工报表

##### 方法
    /export/user
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|userCode|string|员工工号|
|start|string|开始日期|
|end|string|结束日期|

##### 返回值
    员工导入模板文件

### 8、冲值管理接口

#### 8.1、查询冲值记录列表

#### 8.1.1、查询冲值批次列表

##### 方法
    /user/delta/page
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|start|string|开始日期|
|end|string|结束日期|
|page|int|页次|
|pageSize|int|每页显示数|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List|冲值批次结果集|

    冲值批次结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|id|Long|冲值批次Id|
|deltaDate|string|冲值日期|
|deltaNum|int|冲值总人数|
|deltaAmount|BigDecimal|冲值总金额|
|deltaDesc|string|冲值说明|
|addTime|string|创建时间||

#### 8.1.2、查询冲值批次明细列表

##### 方法
    /user/delta/page/detail
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|batchNo|string|冲值批次No|
|page|int|页次|
|pageSize|int|每页显示数|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List|冲值明细结果集|

    冲值明细结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|id|Long|冲值Id|
|userId|long|员工id|
|userCode|stirng|员工工号|
|userName|string|员工姓名|
|cardNo|string|绑定卡号|
|mobile|string|员工手机号|
|amount|BigDecimal|员工余额|
|lastDate|string|上次冲值时间|
|deltaAmount|BigDecimal|本次冲值金额|
|addTime|date|创建时间|

#### 8.2、员工冲值

##### 方法
    /user/delta/amount
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|userCode|string|员工工号|
|amount|BigDecimal|冲值金额|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|结果集|

#### 8.3、查询员工冲值记录

##### 方法
    /user/delta/{userCode}
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|user|string|员工工号/员工姓名|
|start|string|开始日期|
|end|string|结束日期|

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|List|冲值明细结果集|

    冲值明细结果集
|参数名|参数类型|参数描述|说明|
|:--:|:--:|:--:|:--:|
|id|Long|冲值Id|
|userId|long|员工id|
|deltaId|long|导入批次Id|
|userCode|stirng|员工工号|
|userName|string|员工姓名|
|cardNo|string|绑定卡号|
|mobile|string|员工手机号|
|amount|BigDecimal|员工余额|
|lastDate|string|上次冲值时间|
|deltaAmount|BigDecimal|本次冲值金额|
|addTime|date|创建时间|

#### 8.4、导出导入员工冲值模板

##### 方法
    /export/tmpl/delta
    
##### 参数
    无

##### 返回值
    模板文件

#### 8.5、导入员工冲值接口

##### 方法
    /import/goods
    
##### 参数
    员工冲值导入文件

##### 返回值
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|retCode|string|返回类型编号|
|retMsg|string|返回描述|
|retState|string|返回状态|
|apiResult|null|结果集|

#### 8.6、导出员工冲值报表
##### 方法
    /export/delta
    
##### 参数
|参数名|参数类型|参数描述|
|:--:|:--:|:--:|
|user|string|员工工号/员工姓名|
|start|string|开始日期|
|end|string|结束日期|

##### 返回值
    员工冲值记录文件