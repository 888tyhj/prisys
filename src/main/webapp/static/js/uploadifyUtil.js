/**
 * 编辑页面显示文件列表
 * @auto yangl
 * @param id
 * @param pre 传到后台的对象
 * @param idvalue 文件id值
 * @param filecount 可以上传的文件个数
 * @param fileid 上传文件的id
 */
function showFileList(id,pre,idvalue,filecount,fileid){
	$.post(getRootPath()+'/tsysfiles/tsysFilesAction!findTSysFilesByParam.action',{param:" and id='"+idvalue+"' "},function(json){
		$.each(json.rows,function(i,n){
			showFileHtml(n,id,pre,false,filecount,fileid);
		});
	},'json');
}
/**
 * 给页面append值，只针对table
 * @auto yangl
 * @param json 文件对象
 * @param id 显示html的id
 * @param pre 传到后台的对象
 * @param isdeletefile 是否删除源文件
 * @param filecount 可以上传的文件个数
 * @param fileid 上传文件的id
 */
function showFileHtml(json,id,pre,isdeletefile,filecount,fileid){
	var cz="";
    if(containsPic(json.filetype)){
   	 cz+="<a href=\"javascript:showFile('"+json.filename+"');\"  class=\"green btn mini\"><li class=\"icon-picture\"></li>  预览图片</a>";
    }else
    if(json.doc2htmlpath!="" && (json.filetype=='.doc'||json.filetype=='.DOC')){
        cz+="<a href=\"javascript:showWord('"+json.doc2htmlpath+"')\" style='margin-left:5px;' class=\"blue btn mini\"><li class=\"icon-file\"></li>  预览doc</a>";
    }
    else
    if((json.filetype=='.pdf'||json.filetype=='.PDF')){
        cz+="<a href=\"javascript:showFile('"+json.filename+"');\" style='margin-left:5px;' class=\"red btn mini\"><li class=\"icon-file\"></li>  预览pdf</a>";
    }
//    else{
//	     cz+="<a href=\"javascript:downloadFile('"+json.filename+"');\" style='margin-left:5px;'  class=\"purple btn mini\"><li class=\"icon-download\"></li>  下载</a>";
//    }
    cz+="<a href=\"javascript:downloadFile('"+json.filename+"','"+json.filebasename+"');\" style='margin-left:5px;'  class=\"purple btn mini\"><li class=\"icon-download\"></li>  下载</a>";
    cz+="<a href=\"javascript:deleteFile('"+json.filename+"',"+isdeletefile+",'"+id+"','"+fileid+"');\" style='margin-left:5px;'  class=\"purple btn mini\"><li class=\"icon-trash\"></li>  删除</a>";
   
     //文件大小
     //var fl= (parseFloat((json.filelen))/1024/1024).toFixed(2);
     var inputStr='';
     //转化格式后的名称
     inputStr+='<input name="'+pre+'json.filename"   value="'+json.filename+'" style="display:none"/>';
     //保存路径
     inputStr+='<input name="'+pre+'json.filepath"   value="'+json.filepath+'" style="display:none"/>';
    //文件源名称
     inputStr+='<input name="'+pre+'json.filebasename"   value="'+json.filebasename+'" style="display:none"/>';
	
    //文件类型  doc？xls？
     inputStr+='<input name="'+pre+'json.filetype"   value="'+json.filetype+'" style="display:none"/>';
     //文件大小
     inputStr+='<input name="'+pre+'json.filelen"   value="'+json.filelen+'" style="display:none"/>';
    //doc转为html
     inputStr+='<input name="'+pre+'json.doc2htmlpath" value="'+json.doc2htmlpath+'"  style="display:none"/>';
    var tr_str='<tr id="'+getFileNewName(json.filename)+'"> '
        +' <td>'+json.filebasename+'</td> '
        +' <td>'+json.filelen+'</td> '
        +' <td>'+cz+inputStr+'</td> '
        +' </tr>';
	 $(id).append(tr_str);
	 isshowFileButton(id,fileid);
}
function getFileNewName(value){
	if(value!=null){
		var arr=value.split(".");
		return arr[0];
	}else{
		return "";
	}
}
/**
 * 查看文件
 * @param value 文件名称
 * @return
 */
function  showFile(value){
    window.open (getRootPath()+'/download/fileDownLoadAction!showFile.action?fileName='+value,'newwindow','height='+clientHeight+',width=1000,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') 
}
/**
 * 查看word
 * @param value word转化后的名称
 * @return
 */
function showWord(value){
	window.open (getRootPath()+'/upload/'+value+'','newwindow','height='+clientHeight+',width=1000,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') 
}
/**
 * 下载文件
 * @param value 文件名称
 * @return
 */
function  downloadFile(value,fileBaseName){
	$.post(getRootPath()+'/download/fileDownLoadAction!existsFile.action',{fileName:value},function(json){
		 if(json=="存在"){
			 window.location.href=getRootPath()+'/download/fileDownLoadAction!downLoad.action?fileName='+value+'&fileRealName='+fileBaseName;
		 }else{
			 $.messager.alert('提示信息','文件不存在！','error');
		 }
	},'json')
}
/**
 * 下载文件
 * @param value 文件名称
 * @return
 */
function  downloadFile2(value){
  window.open (getRootPath()+'/download/fileDownLoadAction!downLoad.action?fileName='+value,'newwindow','height='+clientHeight+',width=1000,top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') 
}
/**
 * 删除文件
 * @param value 文件名称
 * @return
 */
function  deleteFile(value,isdeletefile,id,fileid){
	$('#'+getFileNewName(value)).remove();
	isshowFileButton(id,fileid);
	if(isdeletefile){
		$.post(getRootPath()+'/download/fileDownLoadAction!deleteFile.action?fileName='+value,null,function(){})
	}
}
function isshowFileButton(id,fileid){
	var fc=$(id+" tr").length;
	if(fc==filecount){
		$(fileid).hide();
	}else{
		$(fileid).show();
	}
}
/**
 * 判断文件是都以指定后缀结尾
 * @param obj
 * @return
 */
function containsPic(obj) {
	var pictypes=['.png','.jpg','.jpeg','.gif','.bmp','.PNG','.JPG','.JPEG','.GIF','.BMP'];
    for (var i = 0; i < pictypes.length; i++) {
        if (pictypes[i] === obj) {
            return true;
        }
    }
    return false;
}
function showFileContent(idvalue){
	$.post(getRootPath()+'/tsysfiles/tsysFilesAction!findTSysFilesByParam.action',{param:" and id='"+idvalue+"' "},function(json){
		if(json.rows.length!=0){
			$.each(json.rows,function(i,n){
				if(n.doc2htmlpath!="" && (n.filetype=='.doc'||n.filetype=='.DOC')){
					showWord(n.doc2htmlpath);
				}else if((n.filetype=='.pdf'||n.filetype=='.PDF')){
					showFile(n.filename);
				}else if(containsPic(n.filetype)){
					showFile(n.filename);
				}else{
					$.messager.alert('提示信息',n.filetype+'文件不支持预览！','info');
				}
			});
		}else{
			$.messager.alert('提示信息','请先上传文件！','info');
		}
	},'json');
}
