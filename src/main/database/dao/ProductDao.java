package dao;

import dto.ProductDto;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Log4j2
public class ProductDao implements  IDoConnection<ProductDto>{


    @Override
    public void create(ProductDto productDto) {
        try (Connection connection = getInterfaceConnection()){
            String sql = "insert into product(name,price) values(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,productDto.getName());
            preparedStatement.setDouble(2,productDto.getPrice());
            int rowEffected = preparedStatement.executeUpdate();
            if (rowEffected>0){
                log.info("product added successfully");
            }else{
                log.error("product not added");
            }

        } catch (Exception e) {
            log.error(ProductDao.class + " Error during the insertion");
            e.printStackTrace();
        }
    }

    @Override
    public void update(ProductDto productDto) {
        try (Connection connection = getInterfaceConnection()){
            String sql = "update product set name=?,price=? where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,productDto.getName());
            preparedStatement.setDouble(2,productDto.getPrice());
            int rowEffected = preparedStatement.executeUpdate();
            if (rowEffected>0){
                log.info("product update successfully");
            }else{
                log.error("product not update");
            }

        } catch (Exception e) {
            log.error(ProductDao.class + " Error during the update");
            e.printStackTrace();
        }

    }

    @Override
    public void delete(ProductDto productDto) {
        try (Connection connection = getInterfaceConnection()){
            String sql = "delete product where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,productDto.getName());
            preparedStatement.setDouble(2,productDto.getPrice());
            int rowEffected = preparedStatement.executeUpdate();
            if (rowEffected>0){
                log.info("product delete successfully");
            }else{
                log.error("product not delete");
            }

        } catch (Exception e) {
            log.error(ProductDao.class + " Error during the delete");
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<ProductDto> list() {
        ArrayList<ProductDto> listem = new ArrayList<>();
        ProductDto productDto;
        try (Connection connection = getInterfaceConnection()){
            String sql = "select * from product";
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                productDto = new ProductDto();
                productDto.setId(resultSet.getInt("id"));
                productDto.setName(resultSet.getString("name"));
                productDto.setPrice(resultSet.getDouble("price"));
                listem.add(productDto);
            }
        } catch (Exception e) {
            log.error(ProductDao.class + " Error during the delete");
            e.printStackTrace();
        }
        return listem;
    }
}
