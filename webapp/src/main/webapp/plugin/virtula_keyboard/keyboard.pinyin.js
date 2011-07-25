

var KeyboardPinyin=function(opts){
this.inputObj=opts["inputObj"];
this.divListArea=opts["divListArea"];
this.divCode=opts["divCode"];
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

}

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
}


KeyboardPinyin.prototype.create_word_list=function(start, index, str){
	var str_len = str.length;
	var cnt = 1;
	var same_code_words =this.code_table[start].replace(/[a-z';]+/, '').split(',');
	this.candidates = "";
	while (cnt <= 10) {
		this.candidates += (cnt % 10) + '.' + same_code_words[index] + ' ';
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
		} else {
			this.candidates += ' PgDn>';
		}
	} else if (this.start_stack.length > 1) {
		//for (i=cnt+1; i<=10; i++) document.form1.list_area.value += '\n';
		this.candidates += '<PgUp';
	} else {
		this.candidates += '';//FIXME';
	}
	this.start_mem = start;
	this.index_mem = index;
	this.divListArea.innerHTML = this.candidates + "　"; 
}


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
	this.divCode.innerHTML =  str + "　";
    this.divListArea.innerHTML =  this.candidates + "　";
}

KeyboardPinyin.prototype.insert_char=function(str){
	if (str == "") return;
	if (this.diji) {
		if (/==/.test(this.inputObj.value)) {
			this.inputObj.value = this.inputObj.value.replace(/==/, str+"==");	
		} else {
			this.inputObj.value += str;
		}
	} else {
		switch (this.browser) {
			case 'IE':
				var r = document.selection.createRange();
				r.text=str;
				r.select();
				break;
			case 'NS':
				var obj = this.inputObj;
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
				this.inputObj.value += str;
		}
	}
} 

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
				this.divCode.innerHTML = "　";
				this.candidates = "";
				this.divListArea.innerHTML = "　";
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
					this.divCode.innerHTML = "　";
					this.candidates = "";
					this.divListArea.innerHTML = "　";
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
}

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
}



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
}

KeyboardPinyin.prototype.highlight_copy=function(){
	if (this.browser == 'IE') {
		str_len = this.inputObj.value.length;
		// document.form1.edit_area.value += '\n------------------\n以上文字借助www.JustInput.com在线中文输入法输入';
		var range = this.inputObj.createTextRange();
		range.execCommand("Copy");
		this.inputObj.value = this.inputObj.value.substr(0,str_len);
	} else if (this.inputObj.value.indexOf('JustInput.com') == -1) {
		// document.form1.edit_area.value += '\n------------------\n以上文字借助www.JustInput.com在线中文输入法输入';
	}
	this.inputObj.select();
}

KeyboardPinyin.prototype.clear_all=function(){
	this.code_field = "";
	this.divCode.innerHTML = "　";
	this.candidates = "";
	this.divListArea.innerHTML = "　";
}


