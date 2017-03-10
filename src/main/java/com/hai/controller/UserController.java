package com.hai.controller;

import com.hai.base.BaseController;
import com.hai.exception.CustomException;
import com.hai.model.User;
import com.hai.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by as on 2017/3/2.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final String FILE_UPLOAD_PATH = "D:\\Data\\upload\\images";
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ResourceBundleMessageSource messageSource;

    /*@InitBinder
    public void initBinder(WebDataBinder binder) {
        System.out.println(this.getClass().getName() + ".initBinder...");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，false:不能为空值
    }*/

    /*
    @Valid 和 BindingResult 必须成对出现且中间不能有其它参数
     */
    @RequestMapping("login")
    public String login(@Valid User user, BindingResult result) {
        System.out.println("UserController.login...");
        return "user/home";
    }

    @RequestMapping(value = "/add")
    public String add(User user) {
        System.out.println("UserController.add(user3)...");
        print(user);
        return "user/add";
    }
/*
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String add(@Valid User user, BindingResult result) {
        System.out.println("UserController.add()...");
        if (result.hasErrors()) {
            System.out.println("errors:");
            List<ObjectError> errorList = result.getAllErrors();
            for (ObjectError error : errorList) {
                print(error);
            }
            return "common/errors/error";
        }
        this.userService.add(user);
        return "user/add";
    }
*/

    @ResponseBody
    @RequestMapping("/delete")
    public String delete(User user) throws CustomException {
        System.out.println("UserController.delete()...");
        this.userService.delete(user);
        if (true) {
            throw new CustomException("自定义全局异常测试");
        }
        return "200";
    }

    @ResponseBody
    @RequestMapping("/deleteById/{userId}")
    public String deleteById(@PathVariable Integer userId) {
        System.out.println("UserController.deleteById()...");
        System.out.println();
        this.userService.deleteById(userId);
        return "200";
    }

    @RequestMapping("/update")
    public String update(@RequestBody User user) {
        System.out.println("UserController.update()...");
        this.userService.update(user);
        return "user/update";
    }

    @RequestMapping("/getById/{userId}")
    public String getById(@PathVariable Integer userId) {
        System.out.println("UserController.getById()...");
        this.userService.getById(userId);
        return "user/detail";
    }

    @RequestMapping("/list")
    public String find() {
        System.out.println("UserController.find()...");
        this.userService.find();
        return "user/list";
    }


    /**
     * 文件下载测试
     *
     * @param session
     * @return
     */
    @RequestMapping("/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) {

        ServletContext context = session.getServletContext();
        InputStream in = context.getResourceAsStream("/WEB-INF/files/ssm.log");
        BufferedInputStream bis = new BufferedInputStream(in);
        byte[] buffer = null;
        try {
            buffer = new byte[in.available()];
            //inputStream.read(buffer);
            bis.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=ssm.log");

        HttpStatus httpstatus = HttpStatus.OK;

        return new ResponseEntity<byte[]>(buffer, headers, httpstatus);
    }


    @RequestMapping("/i18n")
    public String testI18N(Locale locale) {

        String userName = messageSource.getMessage("i18n.username", null, "未找到用户名", locale);
        System.out.println("Username for messageSource: " + userName);

        return "i18n/i18n1";
    }

    @RequestMapping("/upload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file) throws IOException {
        System.out.println("fileUpload...");
//        print(file);
        String originalFilename = file.getOriginalFilename();
        String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
        File f = new File(FILE_UPLOAD_PATH, newFileName);

        System.out.println("contentType: " + file.getContentType());
        System.out.println("name: " + file.getName());
        System.out.println("originalFilename: " + file.getOriginalFilename());
        System.out.println("size: " + file.getSize());
        System.out.println("newFileName: " + newFileName);

        file.transferTo(f);

        return "common/success";
    }

    @RequestMapping("/download")
    public String download(@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {

        ServletContext servletContext = request.getServletContext();
        String path = servletContext.getRealPath("/WEB-INF/files/");
        File file = new File(path, fileName);
        if (null == file || !file.exists()) {
            return "common/errors/error";
        }


        response.setContentType("application/force-download");// 设置强制下载不打开
        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream out = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);

            out = response.getOutputStream();
            bos = new BufferedOutputStream(out, 1024);
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != bos) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != bis) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

}
