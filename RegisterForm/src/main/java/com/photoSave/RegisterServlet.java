package com.photoSave;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by axmedbek on 6/15/17.
 */
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String fname = req.getParameter("fname");
        String lname = req.getParameter("lname");

        InputStream istream = null;
        Part filePart = req.getPart("photo");
        if (filePart != null)
        {
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());

            istream = filePart.getInputStream();
        }
        Connection conn = null;
        String message = null;
        try
        {
            String sql = "insert into register(fname,lname,photo) values(?,?,?)";
            conn = dbUtil.getConnection();
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, fname);
            pr.setString(2, lname);
            if (istream != null)
            {
                pr.setBlob(3, istream);


            }
            int i = pr.executeUpdate();
            if (i > 0)
            {
                System.out.println("Database Recording is successfully..");
            }
            pr.close();
        }
        catch (Exception e)
        {
            System.out.println(message = e.getMessage());
        }
        finally
        {
            if (conn != null)
            {
                try
                {
                    conn.close();

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }

        req.setAttribute("msg", message);
        getServletContext().getRequestDispatcher("/message.jsp").forward(req, resp);

    }
}
