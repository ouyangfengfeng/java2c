package com.stormmq.java2c.transpiler.conversion.elementConverters.fieldAttributesProcessors;

import com.stormmq.java2c.transpiler.conversion.c.gccAttributes.GccAttribute;
import com.stormmq.java2c.transpiler.conversion.c.gccAttributes.variable.GccVariableAttributeName;
import com.stormmq.java2c.transpiler.conversion.elementConverters.ConversionException;
import org.jetbrains.annotations.NotNull;

import javax.lang.model.element.VariableElement;
import java.util.Collection;

import static com.stormmq.java2c.transpiler.conversion.c.gccAttributes.variable.GccVariableAttributeName.deprecated;

public final class DeprecatedFieldAttributesProcessor extends AbstractFieldAttributesProcessor
{
	@NotNull private static final GccAttribute<GccVariableAttributeName> DeprecatedAttribute = new GccAttribute<>(deprecated);
	@NotNull public static final FieldAttributesProcessor Deprecated = new DeprecatedFieldAttributesProcessor();

	private DeprecatedFieldAttributesProcessor()
	{
	}

	@Override
	public void processField(@NotNull final Collection<GccAttribute<GccVariableAttributeName>> gccAttributes, @NotNull final VariableElement field) throws ConversionException
	{
		if (hasAnnotation(field, Deprecated.class))
		{
			gccAttributes.add(DeprecatedAttribute);
		}
	}
}
