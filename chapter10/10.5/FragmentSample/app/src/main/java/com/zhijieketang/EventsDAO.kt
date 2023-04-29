package com.zhijieketang

/**
 * 比赛项目实体类
 */
data class Events(
    //比赛项目名称
    val name: String,
    //  项目图标
    val logo: String,
    //项目描述信息
    val description: String,
)

/**
 * Events数据访问对象
 */
class EventsDAO {

    //   声明保存所有数据的Events列表属性
    val list = mutableListOf<Events>()  // 初始化空的可变List集合对象

    //初始化Events数据
    init {

        // 为了测试，数据写死了。
        list.add(
            Events(
                "Archery",
                "archery.gif",
                "Archery dates back around 10,000 years, when bows and arrows were first used for hunting and warfare, before it developed as a competitive activity in medieval England. A tense and testing sport that requires immense reserves of skill and nerve, Archery is now practised in more than 140 countries around the world."
            )
        )
        list.add(
            Events(
                "Athletics",
                "athletics.gif",
                "Athletics is the perfect expression of the Olympic motto ‘Citius, Altius, Fortius’ (‘Faster, Higher, Stronger’) – the competition requires athletes to run faster, throw further, jump higher and leap longer than their rivals. With 2,000 athletes competing in 47 events, Athletics is the largest single sport at the Games. "
            )
        )
        list.add(
            Events(
                "Badminton",
                "badminton.gif",
                "During the 19th century, British military officers in the Indian town of Poona added a net to the ancient game of battledore (meaning ‘bat’) and shuttlecock, and named this new game after the town.  The sport of Poona was eventually brought back home by the officers, and was played at the Duke of Beaufort’s Gloucestershire residence in 1873. The residence was (and is still) called Badminton House, which is how this thrilling sport got the name used today."
            )
        )


        list.add(
            Events(
                "Basketball",
                "basketball.gif",
                "Basketball was invented in 1891 by Dr James Naismith, a Canadian physical education teacher who wanted to create a game that could be played indoors during the winter by his students at the YMCA in Springfield, Massachusetts.  The first game, which took place in December 1891, used peach baskets for goals. In the 120 years since these humble beginnings, basketball has grown into one of the most exciting and popular team sports in the world."
            )
        )
        list.add(
            Events(
                "Boxing",
                "boxing.gif",
                "Boxing featured at the original Olympic Games in the 7th century BC, when opponents fought with strips of leather wrapped around their fists. The sport’s regulations were codified in 1867 as the Marquess of Queensberry Rules, named in honour of the nobleman who endorsed them. The essence of these rules is still in place today, governing this perennially exciting and dramatic Olympic sport. "
            )
        )
    }
}
