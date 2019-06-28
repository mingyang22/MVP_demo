# MVP_demo
本文主要根据自身项目的使用和对MVP的理解，搭建符合自身项目情况的MVP架构。

#### 关于MVP

M（Model）负责数据的请求，解析，过滤等数据操作。

V（View）负责处理UI，通常以Activity Fragment的形式出现。

P（Presenter）View Model中间件，交互的桥梁。

#### MVP的好处

分离了UI逻辑和业务逻辑，降低了耦合。

Activity只处理UI相关操作，代码变得更加简洁。

UI逻辑和业务逻辑抽象到接口中，方便阅读及维护。

把业务逻辑抽到Presenter中去，避免复杂业务逻辑造成的内存泄漏。
