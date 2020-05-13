$.fn.xcity = function(cName,tName,vName){
    var form = layui.form;

    this.c = $(this).find('select[lay-filter=county]');

    this.t = $(this).find('select[lay-filter=town]');

    this.v = $(this).find('select[lay-filter=village]');

    this.townList = [];

    this.reaList = [];

    this.showC  = function(countyList) {

        this.c.html('');

        is_cName = false;
        
        for (var i in countyList) {
            
            if(cName==countyList[i].name){
                is_cName = true;
                this.townList = countyList[i].townList;
                this.c.append("<option selected value='"+countyList[i].name+"'>"+countyList[i].name+"</option>")
            }else{
                this.c.append("<option value='"+countyList[i].name+"'>"+countyList[i].name+"</option>")
            }
        }
        // if(!is_cName){
        //     this.townList = countyList[0].townList;
        // }
        
    }

    this.showT = function (townList) {

        this.t.html('');

        is_tName = false;

        for (var i in townList) {
            if(tName==townList[i].name){
                is_tName = true;
                this.villageList = townList[i].villageList;
                this.t.append("<option selected value='"+townList[i].name+"'>"+townList[i].name+"</option>")
            }else{
                this.t.append("<option value='"+townList[i].name+"'>"+townList[i].name+"</option>")
            }
        }

        // if(!is_tName){
        //     this.villageList = townList[0].villageList;
        // }
    }

    this.showV = function (villageList) {
        this.v.html('');

        for (var i in villageList) {
            
            if(vName==villageList[i]){
                this.v.append("<option selected value='"+villageList[i]+"'>"+villageList[i]+"</option>")
            }else{
                this.v.append("<option value='"+villageList[i]+"'>"+villageList[i]+"</option>")
            }
        }
    }

    this.showC(countyList);
    this.showT(this.townList);
    this.showV(this.villageList);

    form.render('select');

    form.on('select(county)', function(data){
        var cName = data.value;
        $(data.elem).parents(".x-city").xcity(cName);
    });

    form.on('select(town)', function(data){
        var tName = data.value;
        var cName = $(data.elem).parents(".x-city").find('select[lay-filter=county]').val();
        console.log(cName);
        $(data.elem).parents(".x-city").xcity(cName,tName);
    });

    return this;
}
var countyList = [
    {name:'寿县', townList:[
    {name:'炎刘镇', villageList:['炎光村','引洪岗村','炎中村','李安村','高庙村','圣井村','上岗村','棋杆村','永乐村','李桥村','龙楼村','连塘村','石埠村','三星村','沟东村','桥头村','船涨村']},
    {name:'刘岗镇', villageList:['沈郢村','三义村','眠虎村','陈楼村','汤岗村','郑岗村','双枣村','大拐村','烟店村','刘岗村','塘面村','付楼村','上楼村']},
    {name:'寿春镇', villageList:['陡涧村','兴隆村','湖光村','周寨村','永青社区','东津社区','红星社区','寿滨村','民主社区','新民社区','南关社区','花园村','九龙村','西湖社区','新城社区','南关村']}
    ]}
]
