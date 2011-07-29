

var KeyboardPinyin=function(opts){
this.target=opts["target"];
this.setTarget(this.target);
this.divListArea;
this.divCode;
this.divSelectWord;
this.code_field = "";
this.candidates = "";
this.code_len = 12;
this.code_table = new Array();
this.pattern = /[a-z';]+[^a-z';]+/g;
this.pattern.compile("[a-z';]+[^a-z';]+", "g");
// "raw" is defined in *-table.js
while (this.pattern.exec(raw) != null) this.code_table.push(RegExp.lastMatch);

this.word_list = new Array();
this.left_yinhao1 = false;
this.left_yinhao2 = false;
this.ctrl_keydown = false;
this.right_arrow = false;
this.cancel_key_event = false;
this.start_mem = -1;
this.index_mem = 0;
this.start_stack = new Array();
this.index_stack = new Array();
this.key_en = "1234567890abcdefghijklmnopqrstuvwxyz";
this.key_EN = "1234567890ABCDEFGHIJKLMNOPQRSTUVWXYZ";
this.key_quan = "１２３４５６７８９０ａｂｃｄｅｆｇｈｉｊｋｌｍｎｏｐｑｒｓｔｕｖｗｘｙｚ";
this.key_QUAN = "！·＃＄％…＆＊（）ＡＢＣＤＥＦＧＨＩＪＫＬＭＮＯＰＱＲＳＴＵＶＷＸＹＺ";
this.fuhao = new Array();
this.fuhao[1] = "。，、；：？！…—·ˉˇ¨‘’“”々～‖∶＂＇｀｜〃〔〕〈〉《》「」『』．〖〗【】（）［］｛｝︵︶︹︺︿﹀︽︾﹁﹂﹃﹄︻︼︷︸︱︳︴";
this.fuhao[2] = "≈≡≠＝≤≥＜＞≮≯∷±＋－×÷／∫∮∝∞∧∨∑∏∪∩∈∵∴⊥∥∠⌒⊙≌∽√≒≦≧⊿";
this.fuhao[3] = "ⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩⅪⅫ⒈⒉⒊⒋⒌⒍⒎⒏⒐⒑⒒⒓⒔⒕⒖⒗⒘⒙⒚⒛⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽⑾⑿⒀⒁⒂⒃⒄⒅⒆⒇①②③④⑤⑥⑦⑧⑨⑩㈠㈡㈢㈣㈤㈥㈦㈧㈨㈩";
this.fuhao[4] = "￥￠￡℅℉㎡℃♂♀°′″¤‰§№☆★○●◎◇◆□■△▲▼▽◢◣◤◥※→←↑↓↖↗↘↙〓＿￣―☉⊕〒";
this.fuhao[5] = "─━│┃┄┅┆┇┈┉┊┋┌┍┎┏┐┑┒┓└┕┖┗┘┙┚┛├┝┞┟┠┡┢┣┤┥┦┧┨┩┪┫┬┭┮┯┰┱┲┳┴┵┶┷┸┹┺┻┼┽┾┿╀╁╂╃╄╅╆╇╈╉╊╋═║╒╓╔╕╖╗╘╙╚╛╜╝╞╟╠╡╢╣╤╥╦╧╨╩╪╫╬╭╮╯╰╱╲╳▁▂▃▄▅▆▇█▉▊▋▌▍▎▏▓▔▕";
this.fuhao[6] = "ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩαβγδεζηθικλμνξοπρστυφχψω";
this.fuhao[7] = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
this.fuhao[8] = "āáǎàēéěèīíǐìōóǒòūúǔùǖǘǚǜü";
this.fuhao[9] = "ㄅㄆㄇㄈㄉㄊㄋㄌㄍㄎㄏㄐㄑㄒㄓㄔㄕㄖㄗㄘㄙㄚㄛㄜㄝㄞㄟㄠㄡㄢㄣㄤㄥㄦㄧㄨㄩ˙ˊˇˋ";
this.fuhao[10] = "ぁあぃいぅうぇえぉおかがきぎくぐけげこごさざしじすずせぜそぞただちぢっつづてでとどなにぬねのはばぱひびぴふぶぷへべぺほぼぽまみむめもゃやゅゆょよらりるれろゎわゐゑをん";
this.fuhao[11] = "ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾタダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤュユョヨラリルレロヮワヰヱヲンヴヵヶ";

this.pattern.compile("[^a-z';]");
	
this.diji=false;

this.browser="IE";

this.lang="ch";  //ch,en
this.fullSharp=true;
this.sign="all";  
this.strokes="all"; 

this.mode="EN";   //EN,en,py 
this.code="";
};

/*
KeyboardPinyin.fuhao=[
	""
	,"。，、；：？！…—·ˉˇ¨‘’“”々～‖∶＂＇｀｜〃〔〕〈〉《》「」『』．〖〗【】（）［］｛｝︵︶︹︺︿﹀︽︾﹁﹂﹃﹄︻︼︷︸︱︳︴"
    ,"≈≡≠＝≤≥＜＞≮≯∷±＋－×÷／∫∮∝∞∧∨∑∏∪∩∈∵∴⊥∥∠⌒⊙≌∽√≒≦≧⊿"
    ,"ⅰⅱⅲⅳⅴⅵⅶⅷⅸⅹⅠⅡⅢⅣⅤⅥⅦⅧⅨⅩⅪⅫ⒈⒉⒊⒋⒌⒍⒎⒏⒐⒑⒒⒓⒔⒕⒖⒗⒘⒙⒚⒛⑴⑵⑶⑷⑸⑹⑺⑻⑼⑽⑾⑿⒀⒁⒂⒃⒄⒅⒆⒇①②③④⑤⑥⑦⑧⑨⑩㈠㈡㈢㈣㈤㈥㈦㈧㈨㈩"
    ,"￥￠￡℅℉㎡℃♂♀°′″¤‰§№☆★○●◎◇◆□■△▲▼▽◢◣◤◥※→←↑↓↖↗↘↙〓＿￣―☉⊕〒"
    ,"─━│┃┄┅┆┇┈┉┊┋┌┍┎┏┐┑┒┓└┕┖┗┘┙┚┛├┝┞┟┠┡┢┣┤┥┦┧┨┩┪┫┬┭┮┯┰┱┲┳┴┵┶┷┸┹┺┻┼┽┾┿╀╁╂╃╄╅╆╇╈╉╊╋═║╒╓╔╕╖╗╘╙╚╛╜╝╞╟╠╡╢╣╤╥╦╧╨╩╪╫╬╭╮╯╰╱╲╳▁▂▃▄▅▆▇█▉▊▋▌▍▎▏▓▔▕"    ,"ΑΒΓΔΕΖΗΘΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩαβγδεζηθικλμνξοπρστυφχψω"
    ,"АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя"
    ,"āáǎàēéěèīíǐìōóǒòūúǔùǖǘǚǜü"
    ,"ㄅㄆㄇㄈㄉㄊㄋㄌㄍㄎㄏㄐㄑㄒㄓㄔㄕㄖㄗㄘㄙㄚㄛㄜㄝㄞㄟㄠㄡㄢㄣㄤㄥㄦㄧㄨㄩ˙ˊˇˋ"
    ,"ぁあぃいぅうぇえぉおかがきぎくぐけげこごさざしじすずせぜそぞただちぢっつづてでとどなにぬねのはばぱひびぴふぶぷへべぺほぼぽまみむめもゃやゅゆょよらりるれろゎわゐゑをん"
    ,"ァアィイゥウェエォオカガキギクグケゲコゴサザシジスズセゼソゾタダチヂッツヅテデトドナニヌネノハバパヒビピフブプヘベペホボポマミムメモャヤュユョヨラリルレロヮワヰヱヲンヴヵヶ"
]
**/

KeyboardPinyin.prototype.search_code_table=function(str){
	var start = -1;
	var low = 0;
	var high = this.code_table.length - 1;
	var str_len = str.length;
	while (low <= high) {
		var mid = Math.floor((low+high)/2);
		var code = this.code_table[mid].substr(0, this.code_table[mid].search(this.pattern));
		if (code.substr(0,str_len) == str) {
			start = mid;
			high = mid-1;
		}
		else if (code.substr(0,str_len) > str) high = mid-1;
		else low = mid+1;
	}
	return(start);
};


KeyboardPinyin.prototype.create_word_list=function(start, index, str){
	var str_len = str.length;
	var cnt = 1;
	var same_code_words =this.code_table[start].replace(/[a-z';]+/, '').split(',');
	this.candidates = "";
	var btnPre=$("<button type=\"button\" class=\"fun\" value=\"pre\" >&lt;</button>");
	var btnNext=$("<button type=\"button\" class=\"fun\" value=\"next\" >&gt;</button>");
	var keyboard=this;
	btnPre.click(function(){
	        var val=$(this).val();
			var cls=$(this).attr("class"); 
			keyboard.on_click(val,cls)}
	);
	btnNext.click(function(){
	        var val=$(this).val();
			var cls=$(this).attr("class"); 
			keyboard.on_click(val,cls)}
	);
	this.divSelectWord.empty();
	while (cnt <= 10) {
		this.candidates += (cnt % 10) + '.' + same_code_words[index] + ' ';
		//增加选择按钮
		//var btnSelect="<button type='button' value='"+same_code_words[index]+"'>"
		//                +same_code_words[index]+"</button>";
		var btnSelect=$("<button type='button' class=\"selectWord\"></button>");
		btnSelect
		.css("width","auto")
		.val(same_code_words[index])
		.html(same_code_words[index])
		;
		var target=this.target;
		var pykeyboard=this;
		btnSelect.click(function(){
		   var val= $(this).val();
		   var tVal=$(target).val();
		   var newVal=tVal+val;
		   $(target).val(newVal);
		   pykeyboard.clear_all();
		});
		
		this.divSelectWord.append(btnSelect);
		this.word_list[cnt-1] = same_code_words[index];
		++index;
		if (index >= same_code_words.length) {
			index = 0;
			++start;
			if (start >= this.code_table.length || this.code_table[start].substr(0, str_len) != str) {
				start = -1;
				break;
			}
			same_code_words = this.code_table[start].replace(/[a-z';]+/, '').split(',');
		}
		++cnt;
	}
	if (start > 0) {
		if (this.start_stack.length > 1) {
			this.candidates += '<PgUp  PgDn>';
			this.divSelectWord.prepend(btnPre).append(btnNext);
		} else {
			this.candidates += ' PgDn>';
			this.divSelectWord.append(btnNext);
		}
	} else if (this.start_stack.length > 1) {
		//for (i=cnt+1; i<=10; i++) document.form1.list_area.value += '\n';
		this.candidates += '<PgUp';
		this.divSelectWord.prepend(btnPre);
	} else {
		this.candidates += '';//FIXME';
	}
	this.start_mem = start;
	this.index_mem = index;
	//$(this.divListArea).html(this.candidates + "　"); 
	//this.divSelectWord.html(wordSelects);
};


KeyboardPinyin.prototype.on_code_change=function(str){
	for (i=0;i<=9;i++) {
		this.word_list[i] = "";
	}
	this.candidates = "";
	this.start_stack = new Array();
	this.index_stack = new Array();
	if (str != "") {
		var start = this.search_code_table(str);
		this.start_stack.push(start);
		this.index_stack.push(0);
		if (start >= 0) this.create_word_list(start, 0, str);
	}
	this.divCode.html(str);
    //$(this.divListArea).html(this.candidates + "　");
    if(this.candidates==""){
    	this.divSelectWord.empty();
    }
};

KeyboardPinyin.prototype.insert_char=function(str){
	if (str == "") return;
	if (this.diji) {
		if (/==/.test(this.target.value)) {
			this.target.value = this.target.value.replace(/==/, str+"==");	
		} else {
			this.target.value += str;
		}
	} else {
		switch (this.browser) {
			case 'IE':
				var r = document.selection.createRange();
				r.text=str;
				r.select();
				break;
			case 'NS':
				var obj = this.target;
				var selectionStart = obj.selectionStart;
				var selectionEnd = obj.selectionEnd;
				var oldScrollTop = obj.scrollTop;
				var oldScrollHeight = obj.scrollHeight;
				var oldLen = obj.value.length;
				
				obj.value = obj.value.substring(0, selectionStart) + str + obj.value.substring(selectionEnd);
				obj.selectionStart = obj.selectionEnd = selectionStart + str.length;
				if (obj.value.length == oldLen) {
					obj.scrollTop = obj.scrollHeight;
				} else if (obj.scrollHeight > oldScrollHeight) {
					obj.scrollTop = oldScrollTop + obj.scrollHeight - oldScrollHeight;
				} else {
					obj.scrollTop = oldScrollTop;
				}
				break;
			default:
				this.target.value += str;
		}
	}
} ;

KeyboardPinyin.prototype.key_down=function(e){
	var key = e.which ? e.which : e.keyCode;
	if (key!=33 && key!=57383 && key!=34 && key!=57384) {
        this.sign="all";
        this.strokes="all";
	}
	var key_char = String.fromCharCode(key);
	this.ctrl_keydown = false;
	switch (key) {
		// Backspace
		case 8:
			if (this.code_field != "") {
				var str = this.code_field;
				this.code_field = str.substr(0, str.length-1);
				this.on_code_change(this.code_field);
				this.cancel_key_event = true;
				return false;
			}
			return true;
		// Tab
		case 9:
			this.insert_char('　');
			this.cancel_key_event = true;
			return false; 
		// Esc
		case 27:
			this.clear_all();
			this.cancel_key_event = true;
			return false;
		// PageUp
		case 33:
		case 57383:
			if (this.code_field != "") {
				if(this.start_stack.length > 1) {
					this.start_stack.pop();	this.index_stack.pop();
					this.create_word_list(this.start_stack[this.start_stack.length-1], this.index_stack[this.index_stack.length-1], this.code_field);
				}
				this.cancel_key_event = true;
				return false;
			}
/*			else if (getEl("iFrame").num != undefined) {
				if (getEl("iFrame").start > 0) {
					last_page();
					cancel_key_event = true;
					return false;
				}
			}*/
			return true;
		// PageDown
		case 34:
		case 57384:
			if (this.code_field != "") {
				if (this.start_mem != -1) {
					this.start_stack.push(this.start_mem);
					this.index_stack.push(this.index_mem);
					for(i=0; i<=9; i++) {
						this.word_list[i] = "";
					}
					this.create_word_list(this.start_mem, this.index_mem, this.code_field);
				}
				this.cancel_key_event = true;
				return false;
			}
			/*else if (getEl("iFrame").num != undefined) {
				if ((getEl("iFrame").shurufa=='bihua' && getEl("iFrame").num>100) || (getEl("iFrame").shurufa!='bihua' && getEl("iFrame").num>36)) {
					next_page();
					cancel_key_event = true;
					return false;
				}
			}*/
			return true;
		// Space
		case 32:
			if (this.code_field != "") {
				this.insert_char(this.word_list[0]);
				this.code_field = "";
				$(this.divCode).empty();
				this.candidates = "";
				$(this.divListArea).empty();
				this.cancel_key_event = true;
				return false;
			} /*else if (getEl("iFrame").num != undefined) {
				insert_char(getEl("iFrame").words[0]);
				blank_page();
				cancel_key_event = true;
				return false;
			}*/
			return true;
		// Enter
		case 13:
			if (this.code_field!="") {
				//wait_message();
				//str = "getwords.php?shurufa="+shurufa+"&para2="+jianfan+"&para3="+code_field.toLowerCase()+"&start=0";
				//getEl("iFrame").location.replace(str);
				this.cancel_key_event = true;
				return false;
			}
			return true;
		// Ctrl
		case 17:
		case 57402:
			this.ctrl_keydown = true;
			break;
	}
	
	if (e.ctrlKey) return true;
	
	if (/\d/.test(key_char)) {
		if (e.shiftKey) {
			if (this.fullSharp || this.lang=="ch") {
				if (this.lang=="ch" && key_char=='4') this.insert_char('￥');
				else {
					pos = this.key_EN.indexOf(key_char);
					this.insert_char(this.key_QUAN.substr(pos,1));
				}
				this.cancel_key_event = true;
				return false;
			}
		} else {
			if (this.code_field == "") {
			/*	if (getEl("iFrame").num != undefined) {
					if(key_en.indexOf(key_char) < getEl("iFrame").num) {
						insert_char(getEl("iFrame").words[key_en.indexOf(key_char)]);
						blank_page();
					}
					cancel_key_event = true;
					return false;
				} else if (document.form1.full_shape.checked || document.form1.ch_en_switch[0].checked) {
					pos = key_EN.indexOf(key_char);
					insert_char(key_quan.substr(pos,1));
					cancel_key_event = true;
					return false;
				}*/
			} else {
				if (this.lang=="ch") {
					this.insert_char(this.word_list[(9+parseInt(key_char))%10]);
					this.code_field = "";
					this.divCode.empty();
					this.candidates = "";
					//$(this.divListArea).empty();
					this.divSelectWord.empty();
					this.cancel_key_event = true;
					return false;
				}
			}
		}
		return true;
	}

	if (this.fullSharp || this.lang=="ch") {
//		if ((key>=186 && key<=192) || (key>=219 && key<=222) ) {
		if (key == 186 || (key>=188 && key<=192) || (key>=219 && key<=222) ) {
			if (key == 186) {
				if (this.lang=="ch") {
					if (e.shiftKey) this.insert_char('：');
					else if (this.code_field == "") this.insert_char('；');
					else return true;
				} else {
					this.insert_char( e.shiftKey ? '：' : '；' );
				}
			}
//			else if (key == 187) insert_char( e.shiftKey ? '＋' : '＝' );
			else if (key == 188) this.insert_char( e.shiftKey ? ((this.lang=="ch")? '《' :'＜') : '，' );
			else if (key == 189) this.insert_char( e.shiftKey ? '＿' : '－' );
			else if (key == 190) this.insert_char( e.shiftKey ? ((this.lang=="ch")? '》' :'＞') : (this.lang=="ch")? '。' :'．');
			else if (key == 191) this.insert_char( e.shiftKey ? '？' : '／' );
			else if (key == 192) this.insert_char( e.shiftKey ? '～' : '｀' );
			else if (key == 219) this.insert_char( e.shiftKey ? '｛' : '［' );
			else if (key == 220) this.insert_char( e.shiftKey ? '｜' : (this.lang=="ch")? '、' :'＼');
			else if (key == 221) this.insert_char( e.shiftKey ? '｝' : '］' );
			else {
				if (this.lang=="ch") {
					if (e.shiftKey) this.insert_char( (left_yinhao2 = !left_yinhao2) ? '“' : '”' );
					else if (code_field == "") this.insert_char( (left_yinhao1 = !left_yinhao1) ? '‘' : '’' );
					else return true;
				} else {
					this.insert_char( e.shiftKey ? '＂' : '＇' );
				}
			}
			this.cancel_key_event = true;
			return false;
		}
		if (this.lang=="en" && key == 187) {
			this.insert_char( e.shiftKey ? '＋' : '＝' );
			this.cancel_key_event = true;
			return false;
		}
	}    
	
	if (this.browser == 'NS') {
		if (this.fullSharp || this.lang=="ch") {
			if (key == 59) {
				if (this.lang=="ch") {
					if (e.shiftKey) this.insert_char('：');
					else if (this.code_field == "") this.insert_char('；');
					else return true;
				} else {
					this.insert_char( e.shiftKey ? '：' : '；' );
				}
				this.cancel_key_event = true;
				return false;
			}
			else if (key == 61) {
				if (this.lang=="en") {
					this.insert_char( e.shiftKey ? '＋' : '＝' );
					this.cancel_key_event = true;
					return false;
				}
			}
			else if (key == 109) {
				this.insert_char( e.shiftKey ? '＿' : '－' );
				this.cancel_key_event = true;
				return false;
			}
		}
	}

	this.right_arrow = (key == 39)? true : false;
	
	return(true);
};

KeyboardPinyin.prototype.key_up=function(e){
	var key = e.which ? e.which : e.keyCode;
	// Ctrl
	if (key == 17 || key == 57402) {
		if (ctrl_keydown == true) {
			if (this.lang=="ch") {
				this.lang=="en";
				this.clear_all();
			}
			else {
				this.lang=="ch";
			}
		}
	}
	return true;
};



KeyboardPinyin.prototype.key_press=function(e){
	var key = e.which ? e.which : e.keyCode;
	var key_char = String.fromCharCode(key);
	if (this.browser == 'NS' || this.browser == 'OP') {
		if (this.cancel_key_event) {
			this.cancel_key_event = false;
			return false;
		}
	}
	
	if (e.ctrlKey) return true; 
	if (/[A-Z]/.test(key_char)) {
		if (this.lang=="en") {
			if (this.fullSharp) {
				pos = this.key_EN.indexOf(key_char)
				this.insert_char(this.key_QUAN.substr(pos,1));
				return false;
			}
			return true;
		}
		else key_char = key_char.toLowerCase();
	}
	
	if (/[a-z';]/.test(key_char) && !this.right_arrow) {
		/*if (/[a-z]/.test(key_char) && getEl("iFrame").num != undefined) {
			if(key_en.indexOf(key_char) < getEl("iFrame").num) {
				insert_char(getEl("iFrame").words[key_en.indexOf(key_char)]);
				blank_page();
			}
			return false;
		}*/
		if (this.lang=="en") {
			if (this.fullSharp) {
				pos = this.key_en.indexOf(key_char)
				this.insert_char(this.key_quan.substr(pos,1));
				return false;
			}
			return true;
		} else {
			if (this.code_field.length < this.code_len) {
				this.code_field += key_char;
				this.on_code_change(this.code_field);
			}
			return false;
		}
	}
	
	if (this.browser == 'NS' && (key == 47 || key == 63)) {
		if (this.lang=="ch"|| this.fullSharp) return false;
	}

	return true;
};

KeyboardPinyin.prototype.highlight_copy=function(){
	if (this.browser == 'IE') {
		str_len = this.target.value.length;
		// document.form1.edit_area.value += '\n------------------\n以上文字借助www.JustInput.com在线中文输入法输入';
		var range = this.target.createTextRange();
		range.execCommand("Copy");
		this.target.value = this.target.value.substr(0,str_len);
	} else if (this.target.value.indexOf('JustInput.com') == -1) {
		// document.form1.edit_area.value += '\n------------------\n以上文字借助www.JustInput.com在线中文输入法输入';
	}
	this.target.select();
};

KeyboardPinyin.prototype.clear_all=function(){
	this.code_field = "";
	this.code="";
	this.divCode.empty();
	this.candidates = "";
	//$(this.divListArea).empty();
	this.divSelectWord.empty();
};

KeyboardPinyin.prototype.loadKeyboard=function(regexp){
	if(!$(regexp)) return false;
	
	var btnA=$("<button type=\"button\" class=\"letter\" value=\"A\" >A</button>");
	var btnB=$("<button type=\"button\" class=\"letter\" value=\"B\" >B</button>");
	var btnC=$("<button type=\"button\" class=\"letter\" value=\"C\" >C</button>");
	var btnD=$("<button type=\"button\" class=\"letter\" value=\"D\" >D</button>");
	var btnE=$("<button type=\"button\" class=\"letter\" value=\"E\" >E</button>");
	var btnF=$("<button type=\"button\" class=\"letter\" value=\"F\" >F</button>");
	var btnG=$("<button type=\"button\" class=\"letter\" value=\"G\" >G</button>");
	var btnH=$("<button type=\"button\" class=\"letter\" value=\"H\" >H</button>");
	var btnI=$("<button type=\"button\" class=\"letter\" value=\"I\" >I</button>");
	var btnJ=$("<button type=\"button\" class=\"letter\" value=\"J\" >J</button>");
	var btnK=$("<button type=\"button\" class=\"letter\" value=\"K\" >K</button>");
	var btnL=$("<button type=\"button\" class=\"letter\" value=\"L\" >L</button>");
	var btnM=$("<button type=\"button\" class=\"letter\" value=\"M\" >M</button>");
	var btnN=$("<button type=\"button\" class=\"letter\" value=\"N\" >N</button>");
	var btnO=$("<button type=\"button\" class=\"letter\" value=\"O\" >O</button>");
	var btnP=$("<button type=\"button\" class=\"letter\" value=\"P\" >P</button>");
	var btnQ=$("<button type=\"button\" class=\"letter\" value=\"Q\" >Q</button>");
	var btnR=$("<button type=\"button\" class=\"letter\" value=\"R\" >R</button>");
	var btnS=$("<button type=\"button\" class=\"letter\" value=\"S\" >S</button>");
	var btnT=$("<button type=\"button\" class=\"letter\" value=\"T\" >T</button>");
	var btnU=$("<button type=\"button\" class=\"letter\" value=\"U\" >U</button>");
	var btnV=$("<button type=\"button\" class=\"letter\" value=\"V\" >V</button>");
	var btnW=$("<button type=\"button\" class=\"letter\" value=\"W\" >W</button>");
	var btnX=$("<button type=\"button\" class=\"letter\" value=\"X\" >X</button>");
	var btnY=$("<button type=\"button\" class=\"letter\" value=\"Y\" >Y</button>");
	var btnZ=$("<button type=\"button\" class=\"letter\" value=\"Z\" >Z</button>");
	var btn0=$("<button type=\"button\" class=\"num\"  value=\"0\" >0</button>");
	var btn1=$("<button type=\"button\" class=\"num\" value=\"1\" >1</button>");
	var btn2=$("<button type=\"button\" class=\"num\" value=\"2\" >2</button>");
	var btn3=$("<button type=\"button\" class=\"num\" value=\"3\" >3</button>");
	var btn4=$("<button type=\"button\" class=\"num\" value=\"4\" >4</button>");
	var btn5=$("<button type=\"button\" class=\"num\" value=\"5\" >5</button>");
    var btn6=$("<button type=\"button\" class=\"num\" value=\"6\" >6</button>");
	var btn7=$("<button type=\"button\" class=\"num\" value=\"7\" >7</button>");
	var btn8=$("<button type=\"button\" class=\"num\" value=\"8\" >8</button>");
    var btn9=$("<button type=\"button\" class=\"num\" value=\"9\" >9</button>");
	var btn0=$("<button type=\"button\" class=\"num\" value=\"0\" >0</button>");
	var btnEN=$("<button type=\"button\" class=\"mode clicked\" value=\"EN\" >EN</button>");
	var btnEn=$("<button type=\"button\" class=\"mode\" value=\"en\" >en</button>");
	var btnPY=$("<button type=\"button\" class=\"mode\" value=\"PY\" >拼音</button>");
	var btnBck=$("<button type=\"button\" class=\"fun\" value=\"bck\" >退格</button>");
	var btnClr=$("<button type=\"button\" class=\"fun\" value=\"clr\" >清空</button>");
    var btnSpc=$("<button type=\"button\" class=\"sign\" value=\"spc\" >空格</button>");
	//var divTop=$("<div class=\"top\"></div>");
	var tableTop=$("<table class=\"top\" border=1></table>");
	this.divCode=$("<td class=\"code\"></td>");
	this.divSelectWord=$("<td class=\"selectWords\"></td>");
	var tr=$("<tr></tr>");
	tr.append(this.divCode).append(this.divSelectWord);
	tableTop.append(tr);
	
	var divKeyboard=$("<div></div>");
	divKeyboard
	.append(tableTop)
	.append(btn1)
	.append(btn2)
	.append(btn3)
	.append(btn4)
	.append(btn5)
	.append(btn6)
	.append(btn7)
	.append(btn8)
	.append(btn9)
	.append(btn0)
	.append(btnBck).append("<br/>")
	.append(btnQ)
	.append(btnW)
	.append(btnE)
	.append(btnR)
	.append(btnT)
	.append(btnY)
	.append(btnU)
	.append(btnI)
	.append(btnO)
	.append(btnP)
	.append(btnClr).append("<br/>")
	.append(btnA)
	.append(btnS)
	.append(btnD)
	.append(btnF)
	.append(btnG)
	.append(btnH)
	.append(btnJ)
	.append(btnK)
	.append(btnL).append("<br/>")
	.append(btnZ)
	.append(btnX)
	.append(btnC)
	.append(btnV)
	.append(btnB)
	.append(btnN)
	.append(btnM)
	.append(btnSpc)
	.append(btnEN)
	.append(btnEn)
	.append(btnPY)
	
	;
	var keyborad=this;
	$(regexp).html(divKeyboard);
    divKeyboard.find("button").each(function(index){
		$(this).click(function(){
			var val=$(this).val();
			var cls=$(this).attr("class");
			keyborad.on_click(val,cls);
		});
	});
    divKeyboard.find("button.mode").each(function(index){
		$(this).click(function(){
              divKeyboard.find("button.mode").removeClass("clicked");
              $(this).addClass("clicked");
		});
	});
};


KeyboardPinyin.prototype.on_click=function(val,cls){
	if(!val)return ;
	switch(cls){
	 case "num" :{
		 //if(this.mode!="EN" && this.mode!="en" ) {break;}
		 var tval=$(this.target).val();
		 var newVal=tval+val;
		 $(this.target).val(newVal);
		 break;
	 }
     case "letter" :{
		 var tval=$(this.target).val();
		 if(this.mode=="en"){
			 val=val.toString().toLowerCase();
		 }else if(this.mode=="EN"){
			 val=val.toString().toUpperCase();
		 }else if(this.mode="py"){
			 //var code=$.trim(this.divCode.html());
			 this.code+=val.toString().toLowerCase();
			 this.on_code_change(this.code);
			 break;
		 }
		 var newVal=tval+val;
		 $(this.target).val(newVal);
		 break;
	 }
     
     case "sign" :{
	     if(val=="spc"){
		   var tval=$(this.target).val();
		   var newVal=tval+" ";
		 $(this.target).val(newVal);
		 }
    	 break;
     }
     
     case "mode" :{
    	 this.mode=val;
    	 break;
     }
     case "fun" :{
    	 if(val=="bck"){
    		 if(this.mode=="py"){
			   if(this.code.length>0){
				  this.code=this.code.substr(0,this.code.length-1);
				  this.on_code_change(this.code);
			   }else{
			     var tval=$(this.target).val();
    			 tval=tval.substr(0,tval.length-1);
    			 $(this.target).val(tval);
			   }
    		 }else if(this.mode=="EN" || this.mode=="en"){
    			 var tval=$(this.target).val();
    			 tval=tval.substr(0,tval.length-1);
    			 $(this.target).val(tval);
    		 }
    	 }else if(val=="clr"){
		     if(this.mode=="py"){
			    if(this.code.length>0){
				  this.clear_all();
				}else{
				  $(this.target).val("");
				}		    
			 }else if(this.mode=="EN" || this.mode=="en"){
			    $(this.target).val("");
			 }
    	 }else if(val=="pre"){
		 	if (this.code.length>0) {
				if(this.start_stack.length > 1) {
					this.start_stack.pop();	this.index_stack.pop();
					this.create_word_list(this.start_stack[this.start_stack.length-1], this.index_stack[this.index_stack.length-1], this.code_field);
				}
				this.cancel_key_event = true;
			}
		 }else if(val=="next"){
		   	if (this.code.length>0) {
				if (this.start_mem != -1) {
					this.start_stack.push(this.start_mem);
					this.index_stack.push(this.index_mem);
					for(i=0; i<=9; i++) {
						this.word_list[i] = "";
					}
					this.create_word_list(this.start_mem, this.index_mem, this.code_field);
				}
				this.cancel_key_event = true;
			}
		 }
		 break;
     }
	 default:{break;}	 
	}
	$(this.target).focus();
};

KeyboardPinyin.prototype.setTarget=function(target){
	$(this.target).removeClass("focus");
	this.target=target;
	$(this.target).addClass("focus");
};



