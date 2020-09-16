package es.upm.miw.iwvg_devops;

import org.apache.logging.log4j.LogManager;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameByUserNameDistinct(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }

    public Stream<Integer> findFractionNumeratorByUserFamilyName(String userFamilyName) {
        return new UsersDatabase().findAll()
                .peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                .peek(x -> LogManager.getLogger(this.getClass()).info("after: " + x))
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::getNumerator);
    }

    public Stream<String> findUserFamilyNameByFractionDenominator(int fractionDenominator) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fractionDenominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }

    public Stream<String> findUserFamilyNameInitialByAnyProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.ProperFraction()))
                .map(User::getFamilyName)
                .map(familyNameInitial -> familyNameInitial.substring(0,1));//creo que he de usar la funcion de usuario
        //return Stream.empty();
    }

    public Stream<String> findUserIdByAnyProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.ProperFraction()))
                .map(User::getId);
        //return Stream.empty();
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String familyName){
        return new UsersDatabase().findAll()
                .filter(user -> user.getFamilyName().equals(familyName))
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream())
                .reduce((fraction, fraction2) -> fraction2.fractionMultiplication(fraction, fraction2))
                .get();
        //return null;
    }

    public Fraction findFirstFractionDivisionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream()).limit(2)
                .reduce((fraction, fraction2) -> fraction2.fractionDivision(fraction, fraction2))
                .get();
        //return null;
    }

    public Double findFirstDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream()).limit(1)
                .mapToDouble(fraction -> fraction.getNumerator()/fraction.getDenominator()).sum();

        //return null;
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .allMatch(fraction -> fraction.ProperFraction()))
                .map(User::getId);
        //return Stream.empty();
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream())
                .filter(fr -> fr.ImproperFraction())
                .map(fraction -> fraction.decimal());

        //return Stream.empty();
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream())
                .filter(fr -> fr.ProperFraction() ).findFirst()
                .get();
        //return null;
    }

    public Stream<String> findUserFamilyNameByImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.ImproperFraction()))
                .map(User::getFamilyName);
        //return Stream.empty();
    }

    public Fraction findHighestFraction() {
        return new UsersDatabase().findAll()
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream())
                .reduce((fraction, fraction2) -> fraction2.Biggest(fraction, fraction2))
                .get();
        //return null;
    }

    public Stream<String> findUserNameByAnyImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fraction.ImproperFraction()))
                .map(User::getName);
        //return Stream.empty();
    }

    public Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        List<Fraction> fractions1 = List.of(
                new Fraction(0, -1),
                new Fraction(1, -1),
                new Fraction(2, -1)
        );
        Stream<User> user1 = Stream.of(
                new User("1", "Oscar", "Fernandez", fractions1)
        );
        return user1
                .filter(user -> user.getFractions().stream()
                        .allMatch(fraction -> fraction.getDenominator()<0.0 || fraction.getNumerator()<0.0))
                .map(User::getFamilyName);
        //return Stream.empty();
    }

    public Stream<Double> findDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream())
                .map(fraction -> fraction.decimal());
        //return Stream.empty();
    }

    public Stream<Double> findDecimalFractionByNegativeSignFraction() {
        return new UsersDatabase().findAll()
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream())
                .filter(fraction -> fraction.getDenominator()<0.0 || fraction.getNumerator()<0.0)
                .map(fraction -> fraction.decimal());
        //return Stream.empty();
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getId().equals(id))
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream())
                .reduce((fraction, fraction2) -> fraction2.fractionAddition(fraction, fraction2))
                .get();
        //return null;
    }

    public Fraction findFirstFractionSubtractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .map(user -> user.getFractions())
                .flatMap(fractions -> fractions.stream()).limit(2)
                .reduce((fraction, fraction2) -> fraction2.fractionSubtraction(fraction, fraction2))
                .get();
        //return null;
    }

}