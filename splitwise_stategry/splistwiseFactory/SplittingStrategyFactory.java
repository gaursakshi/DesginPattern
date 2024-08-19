package splitwise_stategry.splistwiseFactory;

import splitwise_stategry.strategyPattern.EqualStrategy;
import splitwise_stategry.strategyPattern.ExactStrategy;
import splitwise_stategry.strategyPattern.PercentageStrategy;
import splitwise_stategry.strategyPattern.SplittingStrategy;

public class SplittingStrategyFactory {

    public  static SplittingStrategy getSplittingStrategy(String strategyName) {
        switch (strategyName.toUpperCase()) {
            case "EQUAL":
                return new EqualStrategy();
            case "EXACT":
                return new ExactStrategy();
            case "PERCENTAGE":
                return new PercentageStrategy();
            default:
                throw new IllegalArgumentException("Unknown strategy type");
        }
    }


}
