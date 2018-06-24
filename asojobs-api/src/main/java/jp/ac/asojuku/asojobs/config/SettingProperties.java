package jp.ac.asojuku.asojobs.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;


public class SettingProperties {
	private static Properties conf = new Properties();

    private static SettingProperties instance = new SettingProperties();

    /**
     * 唯一のインスタンスを返す.
     */
    public static SettingProperties getInstance()
    {
        return instance;
    }

    /**
     * コンストラクタ.<br>
     * シングルトンのためprivate。ファイルから内容を読み込む
     */
    private SettingProperties()
    {
        // クラスローダを使ってクラスパスからの相対パスでファイルを指定
        String fileName =
        		SettingProperties.class.getClassLoader().getResource("setting.properties").getPath();
        try (FileInputStream fi = new FileInputStream(fileName)) {
            // ファイルから読み込み
            conf.load(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * setting.peropertiesから値を取得する
     *
     * @throws IOException ファイルが開けない
     */
    public Map getInfo() throws IOException
    {
    	Map propertiesMap = new HashMap();
    	for (Entry<Object, Object> e : conf.entrySet()) {
			propertiesMap.put(e.getKey(),e.getValue());
		}

        return propertiesMap;
    }
}
