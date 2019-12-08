/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package tech.firas.util

import kotlin.jvm.JvmStatic
import kotlin.random.Random

/**
 * For generating random of the basic data types
 *
 * @param random a kotlin.random.Random
 */
class BasicRandomUtils(private val random: Random) {

    companion object {

        private val singleton = BasicRandomUtils(Random.Default)

        private val specialCharInFrench = charArrayOf(
                'à', 'â', 'è', 'é', 'ê', 'î', 'ï', 'ô', 'ö', 'ù', 'û', 'ü', 'ç', 'œ', 'æ',
                'À', 'Â', 'È', 'É', 'Ê', 'Ë', 'Î', 'Ï', 'Ô', 'Ö', 'Ù', 'Û', 'Ç', 'Œ', 'Æ'
        )

        private val commonChineseCharacters = "阿啊哎哀唉埃挨癌矮艾爱碍安氨俺岸按案暗昂" +
                "凹熬傲奥澳八巴叭吧拔把坝爸罢霸白百柏摆败" +
                "拜班般颁斑搬板版办半伴扮瓣邦帮膀傍棒包胞" +
                "宝饱保堡报抱豹暴爆卑杯悲碑北贝备背倍被辈" +
                "奔本崩逼鼻比彼笔币必毕闭辟碧蔽壁避臂边编" +
                "蝙鞭扁便变遍辨辩标表别宾滨冰兵丙柄饼并病" +
                "拨波玻剥播脖伯驳泊勃博搏膊薄卜补捕不布步" +
                "部擦猜才材财裁采彩踩菜蔡参餐残蚕惨灿仓苍" +
                "舱藏操曹槽草册侧测策层叉插查茶察差拆柴缠" +
                "产阐颤昌长肠尝偿常厂场畅倡唱抄超巢朝潮吵" +
                "炒车扯彻撤尘臣沉陈闯衬称趁撑成呈承诚城乘" +
                "惩程橙吃池驰迟持匙尺齿斥赤翅充冲虫崇抽仇" +
                "绸愁筹酬丑瞅臭出初除厨础储楚处触川穿传船" +
                "喘串窗床晨创吹垂锤春纯唇醇词瓷慈辞磁雌此" +
                "次刺从匆葱聪丛凑粗促催脆翠村存寸措错搭达" +
                "答打大呆代带待袋逮戴丹单担胆旦但诞弹淡蛋" +
                "氮当挡党荡刀导岛倒蹈到盗道稻得德的灯登等" +
                "邓凳瞪低堤滴迪敌笛底抵地弟帝递第颠典点电" +
                "店垫淀殿雕吊钓调掉爹跌叠蝶丁叮盯钉顶订定" +
                "丢东冬懂动冻洞都斗抖陡豆督毒读独堵赌杜肚" +
                "度渡端短段断锻堆队对吨敦蹲盾顿多夺朵躲俄" +
                "鹅额恶饿鳄恩儿而尔耳二发乏伐罚阀法帆番翻" +
                "凡烦繁反返犯泛饭范贩方坊芳防妨房肪仿访纺" +
                "放飞非啡菲肥废沸肺费分纷芬坟粉份奋愤粪丰" +
                "风枫封疯峰锋蜂冯逢缝凤奉佛否夫肤孵弗伏扶" +
                "服浮符幅福辐蝠抚府辅腐父付妇负附复赴副傅" +
                "富赋腹覆该改钙盖溉概干甘杆肝赶敢感刚岗纲" +
                "缸钢港高搞稿告戈哥胳鸽割歌阁革格葛隔个各" +
                "给根跟更耕工弓公功攻供宫恭巩拱共贡勾沟钩" +
                "狗构购够估咕姑孤菇古谷股骨鼓固故顾瓜刮挂" +
                "拐怪关观官冠馆管贯惯灌罐光广归龟规硅轨鬼" +
                "柜贵桂滚棍郭锅国果裹过哈孩海害含函寒韩罕" +
                "喊汉汗旱杭航毫豪好号浩耗呵喝合何和河核荷" +
                "盒贺褐赫鹤黑嘿痕很狠恨哼恒横衡轰哄红宏洪" +
                "虹鸿侯喉猴吼后厚候乎呼忽狐胡壶湖葫糊蝴虎" +
                "互户护花华哗滑化划画话桦怀淮坏欢还环缓幻" +
                "唤换患荒慌皇黄煌晃灰恢挥辉徽回毁悔汇会绘" +
                "惠慧昏婚浑魂混活火伙或货获祸惑霍击饥圾机" +
                "肌鸡积基迹绩激及吉级即极急疾集辑籍几己挤" +
                "脊计记纪忌技际剂季既济继寂寄加夹佳家嘉甲" +
                "贾钾价驾架假嫁稼尖坚间肩艰兼监减剪检简碱" +
                "见件建剑健舰渐践鉴键箭江姜将浆僵疆讲奖蒋" +
                "匠降交郊娇浇骄胶焦礁角脚搅叫轿较教阶皆接" +
                "揭街节劫杰洁结捷截竭姐解介戒届界借巾今斤" +
                "金津筋仅紧锦尽劲近进晋浸禁京经茎惊晶睛精" +
                "鲸井颈景警净径竞竟敬境静镜纠究九久酒旧救" +
                "就舅居局菊橘举矩句巨拒具俱剧惧据距聚卷倦" +
                "决绝觉掘嚼军君均菌俊峻卡开凯慨刊堪砍看康" +
                "抗炕考烤靠科棵颗壳咳可渴克刻客课肯坑空孔" +
                "恐控口扣枯哭苦库裤酷夸跨块快宽款狂况矿亏" +
                "葵愧溃昆困扩括阔垃拉啦喇腊蜡辣来莱赖兰拦" +
                "栏蓝篮览懒烂滥郎狼廊朗浪捞劳牢老乐勒雷蕾" +
                "泪类累冷愣厘梨离莉犁璃黎礼李里哩理鲤力历" +
                "厉立丽利励例隶粒俩连帘怜莲联廉脸练炼恋链" +
                "良凉梁粮两亮辆量辽疗聊僚了料列劣烈猎裂邻" +
                "林临淋磷灵玲凌铃陵羚零龄领岭令另溜刘流留" +
                "硫瘤柳六龙笼隆垄拢楼漏露卢芦炉鲁陆录鹿碌" +
                "路驴旅铝履律虑率绿氯滤卵乱掠略伦轮论罗萝" +
                "逻螺裸洛络骆落妈麻马玛码蚂骂吗嘛埋买迈麦" +
                "卖脉蛮满曼慢漫忙芒盲茫猫毛矛茅茂冒贸帽貌" +
                "么没枚玫眉梅媒煤霉每美妹门闷们萌盟猛蒙孟" +
                "梦弥迷谜米泌秘密蜜眠绵棉免勉面苗描秒妙庙" +
                "灭民敏名明鸣命摸模膜摩磨蘑魔抹末沫陌莫漠" +
                "墨默谋某母亩牡姆拇木目牧墓幕慕穆拿哪内那" +
                "纳娜钠乃奶奈耐男南难囊恼脑闹呢嫩能尼泥你" +
                "拟逆年念娘酿鸟尿捏您宁凝牛扭纽农浓弄奴努" +
                "怒女暖挪诺哦欧偶爬帕怕拍排牌派攀盘判叛盼" +
                "庞旁胖抛炮跑泡胚陪培赔佩配喷盆朋棚蓬鹏膨" +
                "捧碰批披皮疲脾匹屁譬片偏篇骗漂飘瓢票拼贫" +
                "频品平评凭苹屏瓶萍坡泼颇婆迫破剖扑铺葡蒲" +
                "朴浦普谱七妻栖戚期欺漆齐其奇歧骑棋旗企岂" +
                "启起气弃汽契砌器恰千迁牵铅谦签前钱潜浅遣" +
                "欠枪腔强墙抢悄敲乔桥瞧巧切茄且窃亲侵秦琴" +
                "禽勤青氢轻倾清情晴顷请庆穷丘秋蚯求球区曲" +
                "驱屈躯趋取娶去趣圈全权泉拳犬劝券缺却雀确" +
                "鹊裙群然燃染嚷壤让饶扰绕惹热人仁忍认任扔" +
                "仍日绒荣容溶熔融柔肉如儒乳辱入软锐瑞润若" +
                "弱撒洒萨塞赛三伞散桑嗓丧扫嫂色森僧杀沙纱" +
                "刹砂傻啥晒山杉衫珊闪陕扇善伤商赏上尚梢烧" +
                "稍少绍哨舌蛇舍设社射涉摄申伸身深神审婶肾" +
                "甚渗慎升生声牲胜绳省圣盛剩尸失师诗施狮湿" +
                "十什石时识实拾蚀食史使始驶士氏世市示式事" +
                "侍势视试饰室是适逝释收手守首寿受兽售授瘦" +
                "书抒叔枢殊疏舒输蔬熟暑署属鼠薯术束述树竖" +
                "数刷耍衰摔甩帅双霜爽谁水税睡顺瞬说丝司私" +
                "思斯撕死四寺似饲松耸宋送颂搜艘苏俗诉肃素" +
                "速宿塑酸蒜算虽随髓岁遂碎穗孙损笋缩所索锁" +
                "他它她塌塔踏胎台抬太态泰贪摊滩坛谈潭坦叹" +
                "炭探碳汤唐堂塘糖躺趟涛掏逃桃陶淘萄讨套特" +
                "疼腾藤梯踢啼提题蹄体替天添田甜填挑条跳贴" +
                "铁厅听廷亭庭停蜓挺艇通同桐铜童统桶筒痛偷" +
                "头投透突图徒涂途屠土吐兔团推腿退吞托拖脱" +
                "驼妥拓唾挖哇蛙娃瓦歪外弯湾丸完玩顽挽晚碗" +
                "万汪亡王网往忘旺望危威微为围违唯惟维伟伪" +
                "尾纬委萎卫未位味胃谓喂慰魏温文纹闻蚊吻稳" +
                "问翁窝我沃卧握乌污屋无吴吾五午伍武舞务物" +
                "误悟雾夕西吸希析息牺悉惜晰稀溪锡熙嘻膝习" +
                "席袭媳洗喜戏系细隙虾瞎峡狭辖霞下吓夏厦仙" +
                "先纤掀鲜闲弦贤咸衔嫌显险县现线限宪陷献腺" +
                "乡相香厢湘箱详祥翔享响想向巷项象像橡削消" +
                "萧硝销小晓孝效校笑些歇协胁斜谐携鞋写泄泻" +
                "卸屑械谢蟹心辛欣新信兴星猩刑行形型醒杏姓" +
                "幸性凶兄匈胸雄熊休修羞朽秀绣袖嗅须虚需徐" +
                "许序叙畜绪续蓄宣玄悬旋选穴学雪血寻巡询循" +
                "训讯迅压呀鸦鸭牙芽崖哑雅亚咽烟淹延严言岩" +
                "沿炎研盐颜衍掩眼演厌宴艳验焰雁燕央扬羊阳" +
                "杨洋仰养氧痒样腰邀摇遥咬药要耀爷也冶野业" +
                "叶页夜液一伊衣医依仪夷宜姨移遗疑乙已以矣" +
                "蚁椅义亿忆艺议亦异役抑译易疫益谊逸意溢毅" +
                "翼因阴音吟银引饮蚓隐印应英婴鹰迎盈营蝇赢" +
                "影映硬哟拥永泳勇涌用优忧幽悠尤犹由邮油游" +
                "友有又右幼诱于予余鱼娱渔愉愚与宇羽雨语玉" +
                "吁育郁狱浴预域欲喻寓御裕遇愈誉豫元员园原" +
                "圆袁援缘源远怨院愿曰约月岳钥悦阅跃越云匀" +
                "允孕运晕韵蕴杂砸灾栽宰载再在咱暂赞脏葬遭" +
                "糟早枣藻灶皂造噪燥躁则择泽责贼怎曾增赠渣" +
                "扎眨炸摘宅窄债沾粘展占战站张章涨掌丈仗帐" +
                "胀账障招找召兆赵照罩遮折哲者这浙针侦珍真" +
                "诊枕阵振镇震争征挣睁蒸整正证郑政症之支汁" +
                "芝枝知织肢脂蜘执直值职植殖止只旨址纸指趾" +
                "至志制治质致智置中忠终钟肿种仲众重州舟周" +
                "洲轴宙皱骤朱株珠诸猪蛛竹烛逐主煮嘱住助注" +
                "贮驻柱祝著筑抓爪专砖转赚庄桩装壮状撞追准" +
                "捉桌着仔兹姿资滋籽子紫字自宗综棕踪总纵走" +
                "奏租足族阻组祖钻嘴最罪醉尊遵昨左作坐座做" +
                "蔼隘庵鞍黯肮拗袄懊扒芭疤捌跋靶掰扳拌绊梆" +
                "绑榜蚌谤磅镑苞褒雹鲍狈悖惫笨绷泵蹦匕鄙庇" +
                "毙痹弊璧贬匾辫彪憋鳖瘪彬斌缤濒鬓秉禀菠舶" +
                "渤跛簸哺怖埠簿睬惭沧糙厕蹭茬岔豺掺搀禅馋" +
                "蝉铲猖敞钞嘲澈忱辰铛澄逞秤痴弛侈耻宠畴稠" +
                "锄雏橱矗揣囱疮炊捶椿淳蠢戳绰祠赐醋簇窜篡" +
                "崔摧悴粹搓撮挫瘩歹怠贷耽档叨捣祷悼蹬嘀涤" +
                "缔蒂掂滇巅碘佃甸玷惦奠刁叼迭谍碟鼎董栋兜" +
                "蚪逗痘睹妒镀缎兑墩盹囤钝咄哆踱垛堕舵惰跺" +
                "讹娥峨蛾扼鄂愕遏噩饵贰筏矾妃匪诽吠吩氛焚" +
                "忿讽敷芙拂俘袱甫斧俯脯咐缚尬丐柑竿尴秆橄" +
                "赣冈肛杠羔膏糕镐疙搁蛤庚羹埂耿梗蚣躬汞苟" +
                "垢沽辜雇寡卦褂乖棺逛闺瑰诡癸跪亥骇酣憨涵" +
                "悍捍焊憾撼翰夯嚎皓禾烘弘弧唬沪猾徊槐宦涣" +
                "焕痪凰惶蝗簧恍谎幌卉讳诲贿晦秽荤豁讥叽唧" +
                "缉畸箕稽棘嫉妓祭鲫冀颊奸歼煎拣俭柬茧捡荐" +
                "贱涧溅槛缰桨酱椒跤蕉侥狡绞饺矫剿缴窖酵秸" +
                "睫芥诫藉襟谨荆兢靖窘揪灸玖韭臼疚拘驹鞠桔" +
                "沮炬锯娟捐鹃绢眷诀倔崛爵钧骏竣咖揩楷勘坎" +
                "慷糠扛亢拷铐坷苛磕蝌垦恳啃吭抠叩寇窟垮挎" +
                "筷筐旷框眶盔窥魁馈坤捆廓睐婪澜揽缆榄琅榔" +
                "唠姥涝烙酪垒磊肋擂棱狸漓篱吏沥俐荔栗砾痢" +
                "雳镰敛粱谅晾寥嘹撩缭瞭咧琳鳞凛吝赁躏拎伶" +
                "聆菱浏琉馏榴咙胧聋窿娄搂篓陋庐颅卤虏赂禄" +
                "吕侣屡缕峦抡仑沦啰锣箩骡蟆馒瞒蔓莽锚卯昧" +
                "媚魅氓朦檬锰咪靡眯觅缅瞄渺藐蔑皿闽悯冥铭" +
                "谬馍摹茉寞沐募睦暮捺挠瑙呐馁妮匿溺腻捻撵" +
                "碾聂孽拧狞柠泞钮脓疟虐懦糯殴鸥呕藕趴啪耙" +
                "徘湃潘畔乓螃刨袍沛砰烹彭澎篷坯劈霹啤僻翩" +
                "撇聘乒坪魄仆菩圃瀑曝柒凄祈脐崎鳍乞迄泣掐" +
                "洽钳乾黔谴嵌歉呛跷锹侨憔俏峭窍翘撬怯钦芹" +
                "擒寝沁卿蜻擎琼囚岖渠痊瘸冉瓤壬刃纫韧戎茸" +
                "蓉榕冗揉蹂蠕汝褥蕊闰腮叁搔骚臊涩瑟鲨煞霎" +
                "筛删煽擅赡裳晌捎勺奢赦呻绅沈笙甥矢屎恃拭" +
                "柿嗜誓梳淑赎蜀曙恕庶墅漱蟀拴栓涮吮烁硕嗽" +
                "嘶巳伺祀肆讼诵酥粟溯隋祟隧唆梭嗦琐蹋苔汰" +
                "瘫痰谭檀毯棠膛倘淌烫滔誊剔屉剃涕惕恬舔迢" +
                "帖彤瞳捅凸秃颓蜕褪屯豚臀驮鸵椭洼袜豌宛婉" +
                "惋皖腕枉妄偎薇巍帷苇畏尉猬蔚瘟紊嗡涡蜗呜" +
                "巫诬芜梧蜈侮捂鹉勿戊昔犀熄蟋徙匣侠暇馅羡" +
                "镶宵潇箫霄嚣淆肖哮啸蝎邪挟懈芯锌薪馨衅腥" +
                "汹锈戌墟旭恤酗婿絮轩喧癣炫绚渲靴薛勋熏旬" +
                "驯汛逊殉丫押涯衙讶焉阎蜒檐砚唁谚堰殃秧鸯" +
                "漾夭吆妖尧肴姚窑谣舀椰腋壹怡贻胰倚屹邑绎" +
                "姻茵荫殷寅淫瘾莺樱鹦荧莹萤颖佣庸咏踊酉佑" +
                "迂淤渝隅逾榆舆屿禹芋冤鸳渊猿苑粤耘陨酝哉" +
                "赃凿蚤澡憎咋喳轧闸乍诈栅榨斋寨毡瞻斩盏崭" +
                "辗栈绽彰樟杖昭沼肇辙蔗贞斟疹怔狰筝拯吱侄" +
                "帜挚秩掷窒滞稚衷粥肘帚咒昼拄瞩蛀铸拽撰妆" +
                "幢椎锥坠缀赘谆卓拙灼茁浊酌啄琢咨姊揍卒佐"

        @JvmStatic
        fun getDefault(): BasicRandomUtils {
            return singleton
        }

        internal fun checkMinLength(minLength: Int) {
            if (minLength < 0) {
                throw IllegalArgumentException("minLength cannot be negative: $minLength")
            }
        }
    }

    fun randomBoolean(): Boolean {
        return this.random.nextBoolean()
    }

    fun randomNullableBoolean(): Boolean? {
        return when (this.random.nextInt(3)) {
            0 -> false
            1 -> true
            else -> null
        }
    }

    /**
     * @param min lower bound (inclusive)
     * @param max upper bound (inclusive)
     */
    fun randomInt(min: Int, max: Int): Int {
        return this.random.nextInt(min, max + 1)
    }

    /**
     * @param min lower bound (inclusive)
     * @param max upper bound (inclusive)
     */
    fun randomLong(min: Long, max: Long): Long {
        return this.random.nextLong(min, max + 1)
    }

    fun randomAsciiChar(): Char {
        // '~' is 126 (0x7E) and DEL is 127 (0x7F)
        val n = randomInt(' '.toInt() - 3, '~'.toInt())
        return when (n) {
            ' '.toInt() - 3 -> '\t' // \u0009
            ' '.toInt() - 2 -> '\n' // \u000A
            ' '.toInt() - 1 -> '\r' // \u000D
            else -> n.toChar()
        }
    }

    fun randomUpperCaseAlphabet(): Char {
        return randomInt('A'.toInt(), 'Z'.toInt()).toChar()
    }

    fun randomLowerCaseAlphabet(): Char {
        return randomInt('a'.toInt(), 'z'.toInt()).toChar()
    }

    fun randomAlphabet(): Char {
        return if (this.random.nextBoolean()) randomUpperCaseAlphabet() else randomLowerCaseAlphabet()
    }

    fun randomDigit(): Char {
        return randomInt('0'.toInt(), '9'.toInt()).toChar()
    }

    fun randomUpperCaseAlphanumeric(): Char {
        val n = this.random.nextInt(10 + 26)
        return if (n < 10) ('0'.toInt() + n).toChar()
        else ('A'.toInt() + n - 10).toChar()
    }

    fun randomLowerCaseAlphanumeric(): Char {
        val n = this.random.nextInt(10 + 26)
        return if (n < 10) ('0'.toInt() + n).toChar()
        else ('a'.toInt() + n - 10).toChar()
    }

    fun randomAlphanumeric(): Char {
        val n = this.random.nextInt(10 + 26 * 2)
        return when {
            n < 10        -> ('0'.toInt() + n).toChar()
            n < (10 + 26) -> ('A'.toInt() + n - 10).toChar()
            else          -> ('a'.toInt() + n - 10 - 26).toChar()
        }
    }

    /**
     * @return one of the most common 3500 Chinese characters
     */
    fun randomCommonChineseChar(): Char {
        return commonChineseCharacters[this.random.nextInt(commonChineseCharacters.length)]
    }

    /**
     * @return a Chinese character in Unicode range 4E00-9FE6
     */
    fun randomBasicChineseChar(): Char {
        return this.randomInt(0x4E00, 0x9FE6).toChar()
    }

    fun randomChineseChar(): Char {
        val range1 = 0x9FE6 - 0x4E00 + 1
        val total1 = range1
        val range2 = 0x4DB5 - 0x3400 + 1
        val total2 = range1 + range2
        val range3 = 0x2A6D6 - 0x20000 + 1
        val total3 = total2 + range3
        val range4 = 0x2B734 - 0x2A700 + 1
        val total4 = total3 + range4
        val range5 = 0x2B81D - 0x2B740 + 1
        val total5 = total4 + range5
        val n = this.random.nextInt(total5)
        return when {
            n < total1 -> (0x4E00 + n).toChar()
            n < total2 -> (0x3400 + n - total1).toChar()
            n < total3 -> (0x20000 + n - total2).toChar()
            n < total4 -> (0x2A700 + n - total3).toChar()
            else       -> (0x2B740 + n - total4).toChar()
        }
    }

    /**
     * @return a random alphabet that may exist in a French word
     */
    fun randomFrenchAlphabet(): Char {
        val n = this.random.nextInt(26 * 2 + specialCharInFrench.size)
        return when {
            n < 26     -> ('A'.toInt() + n).toChar()
            n < 26 * 2 -> ('a'.toInt() + n - 26).toChar()
            else       -> specialCharInFrench[n - 26 * 2]
        }
    }

    fun randomFrenchAlphanumeric(): Char {
        val n = this.random.nextInt(10 + 26 * 2 + specialCharInFrench.size)
        return when {
            n < 10            -> ('0'.toInt() + n).toChar()
            n < (10 + 26)     -> ('A'.toInt() + n - 10).toChar()
            n < (10 + 26 * 2) -> ('a'.toInt() + n - 10 - 26).toChar()
            else              -> specialCharInFrench[n - 10 - 26 * 2]
        }
    }

    fun randomAsciiAndFrenchChar(): Char {
        val n = randomInt(' '.toInt() - 3, '~'.toInt() + specialCharInFrench.size)
        return when {
            (' '.toInt() - 3) == n  -> '\t' // \u0009
            (' '.toInt() - 2) == n  -> '\n' // \u000A
            (' '.toInt() - 1) == n  -> '\r' // \u000D
            n > '~'.toInt()         -> specialCharInFrench[n - '~'.toInt()]
            else -> n.toChar()
        }
    }
}
