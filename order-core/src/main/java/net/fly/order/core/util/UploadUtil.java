package net.fly.order.core.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Random;

/**
 * @author YQH
 * @description: 文件上传
 * @date 2019/9/9 21:27
 * net.fly.order.core.util
 */
@Slf4j
public class UploadUtil {

  /**
   * 生成图片名称
   */
  private static long createImageName() {
    //取当前时间的长整形值包含毫秒
    //long millis = System.currentTimeMillis();
    long millis = System.nanoTime();
    //加上两位随机数
    Random random = new Random();
    int end2 = random.nextInt(99);
    //如果不足两位前面补0
    String str = millis + String.format("%02d", end2);
    long id = new Long(str);
    return id;
  }

  /**
   * 上传文件,上传到服务器目录：savePath/folderName/(每天的日期)/文件
   * @param file 文件
   * @param savePath 保存的目录
   * @param folderName savePath下新建的目录
   * @param accessPath 访问路径
   * @return
   */
  public static String uploadFile(MultipartFile file,String savePath,String folderName,String accessPath){
    //上传的文件信息
    log.info("OriginalFilename：" + file.getOriginalFilename());
    log.info("ContentType：" + file.getContentType());
    log.info("Name：" + file.getName());
    log.info("Size：" + file.getSize());

    //获取文件后缀
    String suffix = "";
    if(file.getOriginalFilename().contains(".")){
      suffix=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
    }

    //获取存放目录,如果目录不存在，则新建目录
    String datePath = folderName+File.separator+DateUtils.getDay(0, "yyyyMMdd")+File.separator;
    String path = savePath+File.separator+datePath;
    File newsDir = new File(path);
    if(!newsDir.exists()){
      newsDir.mkdirs();
    }
    //文件名称
    String fileName = createImageName()+suffix;

    //上传文件，并且获取访问的地址
    String imageUrl = null;
    try{
      // 设置存放图片文件的路径
      String sPath=path + File.separator+fileName;
      // 转存文件到指定的路径
      File sFile = new File(sPath);
      file.transferTo(sFile);
      imageUrl = accessPath+File.separator+datePath+fileName;
    }catch (Exception e){
      e.printStackTrace();
    }

    //图片未上传成功
    if(imageUrl == null){
      return null;
    }

    return imageUrl;
  }
}
