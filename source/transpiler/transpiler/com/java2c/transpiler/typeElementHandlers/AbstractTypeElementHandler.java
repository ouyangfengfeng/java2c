package com.java2c.transpiler.typeElementHandlers;

import com.compilerUser.elementHandlers.typeElementHandlers.TypeElementHandler;
import com.java2c.model.types.scalars.Scalar;
import com.compilerUser.elementHandlers.ElementHandler;
import com.java2c.transpiler.OurAbstractSyntaxTreeInterpreter;
import com.java2c.transpiler.exceptions.ClassAnnotationNotPermittedOnThisTypeElementException;
import org.jetbrains.annotations.NotNull;

import javax.lang.model.element.TypeElement;

public abstract class AbstractTypeElementHandler implements TypeElementHandler<OurAbstractSyntaxTreeInterpreter>
{
	protected AbstractTypeElementHandler()
	{
	}

	@Override
	public void handle(@NotNull final OurAbstractSyntaxTreeInterpreter abstractSyntaxTreeInterpreter, @NotNull final TypeElement element, @NotNull final ElementHandler<TypeElement, OurAbstractSyntaxTreeInterpreter> dispatchingTypeElementHandler)
	{
		guardScalarAnnotationNotPresent(abstractSyntaxTreeInterpreter, element);
	}

	// ? Move to AbstractSyntaxTreeInterpreter
	private static void guardScalarAnnotationNotPresent(@NotNull final OurAbstractSyntaxTreeInterpreter abstractSyntaxTreeInterpreter, @NotNull final TypeElement element)
	{
		if (element.getAnnotation(Scalar.class) != null)
		{
			throw new ClassAnnotationNotPermittedOnThisTypeElementException(Scalar.class, element, abstractSyntaxTreeInterpreter);
		}
	}
}