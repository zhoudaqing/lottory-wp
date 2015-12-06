package com.xhcms.lottery.dc.task.crawl;

import java.util.ArrayList;
import java.util.List;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.CssSelectorNodeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import com.xhcms.lottery.dc.data.LCOdds;
import com.xhcms.lottery.lang.Constants;

/**
 * 篮球 大小分 过关
 * 
 * @author langhsu
 *
 */
public class LC0902Worker extends AbstractLCDataWorker {
	private static final String ROOT = ".box-search-l table.tbl tr";
	private NodeFilter tdFilter = new TagNameFilter("td");

	@Override
	public void crawl(Parser parser) throws ParserException {
		List<LCOdds> data = new ArrayList<LCOdds>();
		NodeList nl = parser.parse(new CssSelectorNodeFilter(ROOT));
		for (NodeIterator it = nl.elements(); it.hasMoreNodes();) {
			NodeList cells = it.nextNode().getChildren();
			cells.keepAllNodesThatMatch(tdFilter);

			LCOdds lc = parseRow(cells);

			if (null != lc) {
				data.add(lc);
			}
		}
		// persist
		if (data.size() < 1) {
			log.warn(" -- [ 09_LC_2 ] data is empty !");
		}
		storeData("lc_odds", data);
	}

	private LCOdds parseRow(NodeList cells) {
		if (cells.size() == 7) {
			try {
				LCOdds lc = new LCOdds(Constants.PLAY_09_LC_2, "1,2");
				parseMatchCode(lc, cells.elementAt(0));
				parseOfftime(lc, formater, cells.elementAt(3));

				for (int i = 4; i <= 5; i++) {
					lc.addOdd(parseOdd(cells.elementAt(i)));
				}

				return lc;
			} catch (Exception e) {
				warn(log, e);
			}
		}
		return null;
	}

}