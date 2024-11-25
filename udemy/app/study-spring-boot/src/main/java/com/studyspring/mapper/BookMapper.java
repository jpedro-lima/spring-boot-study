
package com.studyspring.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.studyspring.models.Book;
import com.studyspring.vo.BookVO;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {
	public BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
	
	@Mapping(source = "key", target = "id")
	Book voToBook(BookVO bookVO);
	
	@Mapping(source = "id", target = "key")
	BookVO bookToVO(Book book);
	
	List<BookVO> bookListToVOList(List<Book> books);
	List<Book> voListToBookList(List<BookVO> bookVOs);
}