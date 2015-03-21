package framework;

import domain.Item;
import domain.User;

/**
 * Created by yangtao.lyt on 2015/03/21 14:15
 */
public interface Context {

    /**
     * 获取指定用户id的用户对象，如果上下文不存在该用户对象，则会新建一个用户对象存放在上下中，并返回该用户对象
     * @param userId
     * @return
     */
    public User getOrCreateGetUser(Long userId);
    /**
     * 获取指定商品id的商品对象，如果上下文不存在该商品对象，则会新建一个商品对象存放在上下文中，并返回该商品对象
     * @param itemId
     * @return
     */
    public Item getOrCreateGetItem(Long itemId);
    /**
     * 累加解析错误的数据条数
     */
    public void increErrorParseLineCount();
    /**
     * 累加解析正确的数据条数
     */
    public void increCorrectedParseLineCount();

}
